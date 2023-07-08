/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author David Sandoval Salvador
 * @E-mail sandovaldavid2201@gmail.com
 * @Fecha 7 jul. 2023
 *
 */
public class Archivo {

    private final String ruta = "C:\\Users\\Sando\\OneDrive\\Documentos\\Programas\\Sistema-de-ventas\\Archivos";
    private String NameFile;
    private String ExtensionFile;
    private File File;
    private RandomAccessFile IA;
    private Header cab;

    public Archivo(String NameFile, String ExtensionFile) {
        this.NameFile = NameFile;
        this.ExtensionFile = ExtensionFile;
        this.File = new File(NameFile + "." + ExtensionFile);
        this.cab = new Header();
    }

    public Archivo() {
        this.NameFile = null;
        this.ExtensionFile = null;
        this.File = null;
    }

    public String getNameFile() {
        return NameFile;
    }

    public void setNameFile(String NameFile) {
        this.NameFile = NameFile;
    }

    public String getExtensionFile() {
        return ExtensionFile;
    }

    public void setExtensionFile(String ExtensionFile) {
        this.ExtensionFile = ExtensionFile;
    }

    public File getFile() {
        return File;
    }

    public void setFile(File File) {
        this.File = File;
    }

    public RandomAccessFile getIA() {
        return IA;
    }

    public void setIA(RandomAccessFile IA) {
        this.IA = IA;
    }

    public Header getCab() {
        return cab;
    }

    public void setCab(Header cab) {
        this.cab = cab;
    }

    public void ReadModeIA() throws FileNotFoundException {
        IA = new RandomAccessFile(getFile(), "r");
    }

    public void ReadWriteModeIA() throws FileNotFoundException {
        IA = new RandomAccessFile(getFile(), "rw");
    }

    public void CreateNewFile() throws IOException {
        if (!File.exists()) {
            File.createNewFile();
            ReadWriteModeIA();
            cab.setIACab(getIA());
            cab.position();
            cab.Write();
        } else {
            ReadWriteModeIA();
            cab.setIACab(getIA());
            cab.position();
            cab.Read();
        }

    }

    public void Close() throws IOException {
        IA.close();
    }

    public long CalculateNRR(int pos) {
        return -1;
    }

    public void Position(int pos) throws IOException {

    }

    public void Write() throws IOException {

    }

    public void Read() throws IOException {

    }

}
