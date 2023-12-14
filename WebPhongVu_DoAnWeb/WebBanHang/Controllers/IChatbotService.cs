using System.Threading.Tasks;

public interface IChatbotService
{
    Task<string> GetChatbotResponse(string userMessage);
    Task SendMessageAsync(string toPhoneNumber, string message);
}
