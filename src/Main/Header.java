/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author David Sandoval Salvador
 * @E-mail sandovaldavid2201@gmail.com
 * @Fecha 7 jul. 2023
 *
 */
public class Header {

    private RandomAccessFile IACab;
    private int RecordsNumber;         //int 4 bytes
    private int RecordsNumberDeleted;  //int 4 bytes
    private int RecordSize;            //int 4 bytes
    //                                  ----------------
    //                                  total = 12 bytes

    public Header() {
        this.RecordsNumber = 0;
        this.RecordSize = 0;
        this.RecordsNumberDeleted = 0;
    }

    public RandomAccessFile getIACab() {
        return IACab;
    }

    public void setIACab(RandomAccessFile IACab) {
        this.IACab = IACab;
    }

    public int getRecordsNumber() {
        return RecordsNumber;
    }

    public void setRecordsNumber(int RecordsNumber) {
        this.RecordsNumber = RecordsNumber;
    }

    public int getRecordSize() {
        return RecordSize;
    }

    public void setRecordSize(int RecordSize) {
        this.RecordSize = RecordSize;
    }

    public int getRecordsNumberDeleted() {
        return RecordsNumberDeleted;
    }

    public void setRecordsNumberDeleted(int RecordsNumberDeleted) {
        this.RecordsNumberDeleted = RecordsNumberDeleted;
    }

    public int getSize() {
        return 12;
    }

    @Override
    public String toString() {
        return "Header{" + "IACab=" + IACab + ", RecordsNumber=" + RecordsNumber + ", RecordSize=" + RecordSize + ", RecordsNumberDeleted=" + RecordsNumberDeleted + '}';
    }

    public void position() throws IOException {
        IACab.seek(0);
    }

    public void Write() throws IOException {
        getIACab().writeInt(getRecordsNumber());
        getIACab().writeInt(getRecordsNumberDeleted());
        getIACab().writeInt(getRecordSize());
    }

    public void Read() throws IOException {
        setRecordsNumber(getIACab().readInt());
        setRecordsNumberDeleted(getIACab().readInt());
        setRecordSize(getIACab().readInt());
    }
}
