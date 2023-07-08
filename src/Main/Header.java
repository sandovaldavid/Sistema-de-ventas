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
    private long RecordsNumber;         //long 8 bytes
    private long RecordsNumberDeleted;  //long 8 bytes
    private int RecordSize;             //int  4 bytes
    //                                  ----------------
    //                                  total = 20 bytes

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

    public long getRecordsNumber() {
        return RecordsNumber;
    }

    public void setRecordsNumber(long RecordsNumber) {
        this.RecordsNumber = RecordsNumber;
    }

    public int getRecordSize() {
        return RecordSize;
    }

    public void setRecordSize(int RecordSize) {
        this.RecordSize = RecordSize;
    }

    public long getRecordsNumberDeleted() {
        return RecordsNumberDeleted;
    }

    public void setRecordsNumberDeleted(long RecordsNumberDeleted) {
        this.RecordsNumberDeleted = RecordsNumberDeleted;
    }

    public int getSize() {
        return 20;
    }

    @Override
    public String toString() {
        return "Header{" + "IACab=" + IACab + ", RecordsNumber=" + RecordsNumber + ", RecordSize=" + RecordSize + ", RecordsNumberDeleted=" + RecordsNumberDeleted + '}';
    }

    public void position() throws IOException {
        IACab.seek(0);
    }

    public void Write() throws IOException {
        getIACab().writeLong(getRecordsNumber());
        getIACab().writeLong(getRecordsNumberDeleted());
        getIACab().writeInt(getRecordSize());
    }

    public void Read() throws IOException {
        setRecordsNumber(getIACab().readLong());
        setRecordsNumberDeleted(getIACab().readLong());
        setRecordSize(getIACab().readInt());
    }
}
