/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Sandoval Salvador
 * @E-mail sandovaldavid2201@gmail.com
 * @Fecha 7 jul. 2023
 *
 */
public class Customer extends Archivo {

    private String DNI;                 //Char(8)  --> 10 bytes
    private String FirstName;           //Char(20) --> 22 bytes
    private String SecondName;          //Char(20) --> 22 bytes
    private String FirstLastName;       //Char(30) --> 32 bytes
    private String SecondLastName;      //Char(30) --> 32 bytes
    private String Nationality;         //Char(20) --> 22 bytes
    private String PhoneNumber;         //Char(9)  --> 11 bytes
    private String CellphoneNumber;     //Char(9)  --> 11 bytes
    private String Addrees;             //Char(40) --> 42 bytes
    private String RUC;                 //Char(10) --> 12 bytes
    private int Age;                    //int      --> 4  bytes
    private Date BirthdayDate;          //Date     --> 20 bytes (save the date like string.)
    private byte Active;                //byte     --> 1  byte  (1 -> true and 0 -> false)
    //-------------------------
    //Total    --> 241 bytes

    public Customer(String FileName, String FileExtension) {
        super(FileName, FileExtension);
    }

    public Customer(String DNI, String FirstName, String SecondName, String FirstLastName, String SecondLastName, String Nationality, String PhoneNumber, String CellphoneNumber, String Addrees, String RUC, int Age, Date BirthdayDate) {
        this.DNI = DNI;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.FirstLastName = FirstLastName;
        this.SecondLastName = SecondLastName;
        this.Nationality = Nationality;
        this.PhoneNumber = PhoneNumber;
        this.CellphoneNumber = CellphoneNumber;
        this.Addrees = Addrees;
        this.RUC = RUC;
        this.Age = Age;
        this.BirthdayDate = BirthdayDate;
        this.Active = (byte) 1;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getFirstLastName() {
        return FirstLastName;
    }

    public void setFirstLastName(String FirstLastName) {
        this.FirstLastName = FirstLastName;
    }

    public String getSecondLastName() {
        return SecondLastName;
    }

    public void setSecondLastName(String SecondLastName) {
        this.SecondLastName = SecondLastName;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getCellphoneNumber() {
        return CellphoneNumber;
    }

    public void setCellphoneNumber(String CellphoneNumber) {
        this.CellphoneNumber = CellphoneNumber;
    }

    public String getAddrees() {
        return Addrees;
    }

    public void setAddrees(String Addrees) {
        this.Addrees = Addrees;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Date getBirthdayDate() {
        return BirthdayDate;
    }

    public void setBirthdayDate(Date BirthdayDate) {
        this.BirthdayDate = BirthdayDate;
    }

    public byte getActive() {
        return Active;
    }

    public void setActive(byte Active) {
        this.Active = Active;
    }

    public int getSize() {
        return 241;
    }

    public String getBirthdayDateString() {
        return Date_String(getBirthdayDate());
    }

    @Override
    public long CalculateNRR(int pos) {
        return getCab().getSize() + pos * getSize();
    }

    @Override
    public void Position(int pos) throws IOException {
        long NRR = CalculateNRR(pos);
        getIA().seek(NRR);
    }

    public String Date_String(Date Fecha) {
        SimpleDateFormat Fecha_Date = new SimpleDateFormat("dd/MM/yyyy");
        String Fecha_cadena = Fecha_Date.format(Fecha);
        return Fecha_cadena;
    }

    public Date String_Date(String Fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        fechaDate = formato.parse(Fecha);
        return fechaDate;
    }

    @Override
    public void Write() throws IOException {
        getIA().writeUTF(String.format("%8.8s", getDNI()));
        getIA().writeUTF(String.format("%30.30s", getFirstName()));
        getIA().writeUTF(String.format("%30.30s", getSecondName()));
        getIA().writeUTF(String.format("%40.40s", getFirstLastName()));
        getIA().writeUTF(String.format("%40.40s", getSecondLastName()));
        getIA().writeUTF(String.format("%20.20s", getNationality()));
        getIA().writeUTF(String.format("%9.9s", getPhoneNumber()));
        getIA().writeUTF(String.format("%9.9s", getCellphoneNumber()));
        getIA().writeUTF(String.format("%40.40s", getAddrees()));
        getIA().writeUTF(String.format("%10.10s", getRUC()));
        getIA().writeInt(getAge());
        getIA().writeUTF(String.format("%8.8s", getBirthdayDateString()));
        getIA().writeByte(getActive());
    }

    @Override
    public void Read() throws IOException {
        setDNI(getIA().readUTF().trim());
        setFirstName(getIA().readUTF().trim());
        setSecondName(getIA().readUTF().trim());
        setFirstLastName(getIA().readUTF().trim());
        setSecondLastName(getIA().readUTF().trim());
        setNationality(getIA().readUTF().trim());
        setPhoneNumber(getIA().readUTF().trim());
        setCellphoneNumber(getIA().readUTF().trim());
        setAddrees(getIA().readUTF().trim());
        setRUC(getIA().readUTF().trim());
        setAge(getIA().readInt());
        String BirthdayDateString = getIA().readUTF().trim();
        try {
            Date BirthdayDate = String_Date(BirthdayDateString);
            setBirthdayDate(BirthdayDate);
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        setActive(getIA().readByte());

    }

}
