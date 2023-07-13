/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author David Sandoval Salvador
 * @E-mail sandovaldavid2201@gmail.com
 * @Fecha 7 jul. 2023
 *
 */
public class Archivo {

    private final String FilePath = "C:\\Users\\Sando\\OneDrive\\Documentos\\Programas\\Archivos-Sistema-de-ventas\\";
    private String FileName;
    private String FileExtension;
    private File File;
    private RandomAccessFile IA;
    private Header cab;

    public Archivo(String FileName, String FileExtension) {
        this.FileName = FileName;
        this.FileExtension = FileExtension;
        this.File = new File(this.FilePath + FileName + "." + FileExtension);
        this.cab = new Header();
    }

    public Archivo() {
        this.FileName = null;
        this.FileExtension = null;
        this.File = null;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getFileExtension() {
        return FileExtension;
    }

    public void setFileExtension(String FileExtension) {
        this.FileExtension = FileExtension;
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

    public int WindowJOption(JInternalFrame ic, Color color, String IcoRoute, String mensaje, String titulo) {
        UIManager.put("OptionPane.background", color);
        Icon icoExit = new ImageIcon(getClass().getResource(IcoRoute));
        Object[] options = {"Si", "No"};
        int answer = JOptionPane.showOptionDialog(ic, mensaje, titulo, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, icoExit, options, options[0]);
        return answer;
    }

    public void WindowJDialog(JInternalFrame ic, Color color, String IcoRoute, String mensaje, String titulo) {
        UIManager.put("OptionPane.background", color);
        Icon ico = new ImageIcon(getClass().getResource(IcoRoute));
        JOptionPane.showMessageDialog(ic, mensaje, titulo, 1, ico);
    }

    public void WindowExit(JInternalFrame ic, String WindowName) {

        int answer = WindowJOption(ic, new Color(190, 215, 233), "/img/exit_option.png", "¿Desea salir de la ventana " + WindowName + " ?", "Salir");
        if (answer == 0) {
            ic.dispose();
        }
    }

}
