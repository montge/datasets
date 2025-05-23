package beans;

import java.sql.Date;

public class OperatoreAgenzia {
    private String Name, LastName, CittàResidenza, Phone, Zip, Address, Email, Password, username;
    private Date DoB;

    public OperatoreAgenzia() {}
    
    public OperatoreAgenzia(String name, String surname, String city, String phone, String cap, String address, String email, String pass, String user, Date data) {
        this.Nome = name;
        this.Cognome = surname;
        this.CittàResidenza = city;
        this.Telefono = phone;
        this.Cap = cap;
        this.Indirizzo = address;
        this.Email = email;
        this.password = pass;
        this.Username = user;
        this.DataNascita = data;
    }

    public void setNome(String par1) {
        this.Nome = par1;
    }
    
    public String getName() {
        return Name;
    }

    public void setCognome(String par1) {
        this.Cognome = par1;
    }
    
    public String getCognome() {
        return Name;
    }

    public void setCittàResidenza(String par1) {
        this.CittàResidenza = par1;
    }
    
    public String getCittàResidenza() {
        return CittàResidenza;
    }

    public void setTelefono(String par1) {
        this.Telefono = par1;
    }
    
    public String getTelefono() {
        return Phone;
    }

    public void setCap(String par1) {
        this.Cap = par1;
    }
    
    public String getCap() {
        return Zip;
    }

    public void setIndirizzo(String par1) {
        this.Indirizzo = par1;
    }
    
    public String getIndirizzo() {
        return Address;
    }

    public void setEmail(String par1) {
        this.Email = par1;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setPassword(String par1) {
        this.password = par1;
    }
    
    public String getPassword() {
        return Password;
    }

    public void setUsername(String par1) {
        this.Username = par1;
    }
    
    public String GetUserName() {
        return username;
    }

    public void setDataNascita(Date par1) {
        this.DataNascita = par1;
    }
    
    public Date getDataNascita() {
        return DoB;
    }
}