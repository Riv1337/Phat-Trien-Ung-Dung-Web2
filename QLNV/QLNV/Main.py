import typing
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5 import QtWidgets
from PyQt5.QtCore import *
from PyQt5 import QtCore
from PyQt5.QtWidgets import QMainWindow, QWidget
from PyQt5.QtWidgets import QApplication
import random
import sys

from os import path

from GUIedit import Ui_MainWindow2
from PyQt5.uic import loadUiType

FORM_CLASS,_=loadUiType(path.join(path.dirname('__file__'),"GUI1.ui"))

import sqlite3


class Main(QMainWindow, FORM_CLASS):
    def __init__(self,parent=None):
        super(Main,self).__init__(parent)
        QMainWindow.__init__(self)
        self.setupUi(self)
        self.Handle_Buttons()
        
    def Handle_Buttons(self):
        self.btn_refresh.clicked.connect(self.GET_DATA)
        self.add.clicked.connect(self.ADD_DATA)
        self.btn_refreshPB.clicked.connect(self.GET_DATAPB)
        self.add2.clicked.connect(self.ADD_DATAPB)
        self.search.clicked.connect(self.TIMKIEM)
        
    def TIMKIEM(self):
        ten = self.hoTen_2.text() 
        if ten =='':
            msg = QMessageBox() 
            msg.setWindowTitle("Error")
            msg.setText("Xin nhập mã NV")
            msg.exec_()
        else :
            db=sqlite3.connect("QLNV.db")
            cursor=db.cursor()
            command =f"SELECT * FROM NhanVien where hoTenNV = '{ten}'"
            
    
            result=cursor.execute(command)
            
            self.table.setRowCount(0)
            for row_number,row_data in enumerate(result):
                self.table.insertRow(row_number)
                for column_number,data in enumerate(row_data):
                    self.table.setItem(row_number,column_number,QTableWidgetItem(str(data)))
            edit_button = QPushButton("Edit")
            edit_button.clicked.connect(self.edit_row)
            self.table.setCellWidget(row_number, 7, edit_button)

            delete_button = QPushButton("Delete")
            delete_button.clicked.connect(self.delete_row)
            self.table.setCellWidget(row_number, 8, delete_button)
    


    def SAVE(self):

        db=sqlite3.connect("QLNV.db")
        cursor=db.cursor()
        tenNV = self.ui.edt_hoTen.text()
        gioiTinh = self.ui.edt_gioiTinh.currentText()
        ngaySinh = self.ui.edt_ngaySinh.text()
        luong = self.ui.edt_luong.text()
        diaChi = self.ui.edt_diaChi.text()
        maPB = self.ui.edt_maPB.text()
        id= self.ui.edt_maNV.text()
        cursor.execute('UPDATE NhanVien Set MaNV =? ,hoTenNV = ?,gioiTinh= ?, ngaySinh = ? ,luong =? ,diaChi = ? , maPB = ? where MaNV = ?', (id,tenNV,gioiTinh,ngaySinh,luong,diaChi,maPB,id))
        cursor.connection.commit()
        cursor.connection.close()

        

    def GET_DATA(self):
        db=sqlite3.connect("QLNV.db")
        cursor=db.cursor()
        command ='''SELECT * FROM NhanVien inner join PhongBan on NhanVien.MaPB=PhongBan.MaPB'''
        result=cursor.execute(command)
        self.table.setRowCount(0)
        for row_number,row_data in enumerate(result):
            self.table.insertRow(row_number)
            for column_number,data in enumerate(row_data):
                self.table.setItem(row_number,column_number,QTableWidgetItem(str(data)))
            edit_button = QPushButton("Edit")
            edit_button.clicked.connect(self.edit_row)
            self.table.setCellWidget(row_number, 7, edit_button)

            delete_button = QPushButton("Delete")
            delete_button.clicked.connect(self.delete_row)
            self.table.setCellWidget(row_number, 8, delete_button)

    def GET_DATAPB(self):
        db=sqlite3.connect("QLNV.db")
        cursor=db.cursor()
        
        command ='''SELECT * FROM PhongBan'''
        result=cursor.execute(command)
        self.table2.setRowCount(0)
        for row_number,row_data in enumerate(result):
            self.table2.insertRow(row_number)
            for column_number,data in enumerate(row_data):
                self.table2.setItem(row_number,column_number,QTableWidgetItem(str(data)))
            edit_button = QPushButton("Edit")
            edit_button.clicked.connect(self.edit_rowPB)
            self.table2.setCellWidget(row_number, 2, edit_button)

            delete_button = QPushButton("Delete")
            delete_button.clicked.connect(self.delete_rowPB)
            self.table2.setCellWidget(row_number, 3, delete_button)
    
    def delete_rowPB(self):
        button = self.sender()
        index = self.table.indexAt(button.pos())
        if index.isValid():
            row = index.row()
            removeID = self.table.itemAt(0,row).text() 
            self.table.removeRow(row)
            db=sqlite3.connect("QLNV.db")
            cursor=db.cursor()
            cursor.execute('''DELETE FROM PhongBan WHERE MaPB = ? ''',(removeID,))
            cursor.connection.commit()
            cursor.connection.close()

    
    
    def ADD_DATAPB(self):
        
        db=sqlite3.connect("QLNV.db")
        cursor=db.cursor()
        tenPB = self.ten_PB.text()
        maPB= self.maPB.text()
        cursor.execute('INSERT INTO PhongBan VALUES (?,?)', (maPB,tenPB))
        cursor.connection.commit()
        cursor.connection.close()
    
    def ADD_DATA(self):
        
        db=sqlite3.connect("QLNV.db")
        cursor1=db.cursor()
        tenNV = self.hoTen.text()
        gioiTinh = self.gioiTinh.currentText()
        ngaySinh = self.dateEdit.text()
        luong = self.luong.text()
        diaChi = self.diaChi.text()
        maPB = self.maPB2.text()
        id=random.randint(0,1000000)
        
        cursor1.execute('INSERT INTO NhanVien VALUES (?,?, ?, ?,?,?,?)', (id,tenNV,gioiTinh,ngaySinh,luong,diaChi,maPB))
        cursor1.connection.commit()
        cursor1.connection.close()
        row_count = self.table.rowCount()
        self.table.insertRow(row_count)
        self.add_val(id,row_count,0)
        self.add_val(tenNV,row_count,1)
        self.add_val(gioiTinh,row_count,2)
        self.add_val(ngaySinh,row_count,3)
        self.add_val(luong,row_count,4)
        self.add_val(diaChi,row_count,5)
        self.add_val(maPB,row_count,6)

        edit_button = QPushButton("Edit")
        edit_button.clicked.connect(self.edit_row)
        self.table.setCellWidget(row_count, 7, edit_button)

        delete_button = QPushButton("Delete")
        delete_button.clicked.connect(self.delete_row)
        self.table.setCellWidget(row_count, 8, delete_button)
        

    def add_val(self,val,row_count,col):
         val_item = QTableWidgetItem(val)
         self.table.setItem(row_count, col, val_item)
    


    def edit_row(self):
        button = self.sender()
        index = self.table.indexAt(button.pos())
        row = index.row()
        if index.isValid():
            self.window=QtWidgets.QMainWindow()
            self.ui = Ui_MainWindow2()
            self.ui.setupUi(self.window)
            self.window.show()
            self.ui.saveTT.clicked.connect(self.SAVE)

            ## Test Segment
            '''
            self.ui.edt_maNV.setText("123")
            self.ui.edt_hoTen.setText("456")
            self.ui.edt_gioiTinh.setCurrentText("Nam")
            date = "01/02/2003"
            qdate = QtCore.QDate.fromString(date, "dd-MM-yyyy")
            self.ui.edt_ngaySinh.setDisplayFormat("dd-MM-yyyy")
            self.ui.edt_ngaySinh.setDate(qdate)
            self.ui.edt_luong.setText("100000")
            self.ui.edt_diaChi.setText("ABC XYZ")
            self.ui.edt_maPB.setText("01")
            '''
            '''
            self.ui.edt_maNV.setText(removeID)
            self.ui.edt_hoTen.setText(self.table.itemAt(1,row).text())
            self.ui.edt_gioiTinh.setCurrentText(self.table.itemAt(2,row).text())
            date = self.table.itemAt(3,row).text()
            qdate = QtCore.QDate.fromString(date, "dd-MM-yyyy")
            self.ui.edt_ngaySinh.setDate(qdate)
            self.ui.edt_luong.setText(self.table.itemAt(4,row).text())
            self.ui.edt_diaChi.setText(self.table.itemAt(5,row).text())
            self.ui.edt_maPB.setText(self.table.itemAt(6,row).text())
            '''

    
    def delete_row(self):
        button = self.sender()
        index = self.table.indexAt(button.pos())
        if index.isValid():
            row = index.row()
            removeID = self.table.itemAt(0,row).text() 
            self.table.removeRow(row)
            db=sqlite3.connect("QLNV.db")
            cursor=db.cursor()
            cursor.execute('''DELETE FROM NhanVien WHERE MaNV = ? ''',(removeID,))
            cursor.connection.commit()
            cursor.connection.close()
            
    def edit_rowPB(self):
        pass
    ##Em ap luc qua chua lam kip ://
def main():
    app=QApplication(sys.argv)
    window=Main()
    window.show()
    app.exec_()    
    
if __name__=='__main__':
    main()
