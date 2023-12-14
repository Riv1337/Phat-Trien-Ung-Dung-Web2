using System;
using System.Threading.Tasks;
using Twilio;
using Twilio.Chat;

public class TwilioChatService : IChatbotService
{
    private const string AccountSid = "YOUR_TWILIO_ACCOUNT_SID";
    private const string AuthToken = "YOUR_TWILIO_AUTH_TOKEN";
    private const string TwilioChatServiceSid = "YOUR_TWILIO_CHAT_SERVICE_SID";

    public async Task<string> GetChatbotResponse(string userMessage)
    {
        TwilioClient.Init(AccountSid, AuthToken);

        // Create a channel and send user's message
        var channel = await ChannelResource.CreateAsync(
            type: ChannelResource.ChannelTypeEnum.Private,
            friendlyName: "YourChannelName"
        );

        await MessageResource.CreateAsync(
            body: userMessage,
            from: "user",  // You can use a unique identifier for the user
            to: channel.Sid,
            servicesSid: TwilioChatServiceSid
        );

        // Retrieve messages from the channel (including the chatbot's response)
        var messages = await MessageResource.ReadAsync(channelSid: channel.Sid);

        // For simplicity, just return the last message in the channel
        return messages.Last()?.Body ?? "No response from the chatbot";
    }
}
