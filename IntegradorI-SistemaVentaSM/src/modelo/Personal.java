package modelo;

public class Personal {
    
    private int idPerso;
    private String nomPerso;
    private String apePerso;
    private String dniPerso;
    private String direcPerso;
    private String emailPerso;
    private String fonoPerso;
    private String usuPerso;
    private String passPerso;
    private int idTipoPer;

    public Personal() {
    }

    public Personal(int idPerso) {
        this.idPerso = idPerso;
    }    
    
    public Personal(String nomPerso, String apePerso, String dniPerso, String direcPerso, String emailPerso, String fonoPerso, String usuPerso, String passPerso) {
        this.nomPerso = nomPerso;
        this.apePerso = apePerso;
        this.dniPerso = dniPerso;
        this.direcPerso = direcPerso;
        this.emailPerso = emailPerso;
        this.fonoPerso = fonoPerso;
        this.usuPerso = usuPerso;
        this.passPerso = passPerso;
    }
    
    public Personal(int idPerso, String nomPerso, String apePerso, String dniPerso, String direcPerso, String emailPerso, String fonoPerso, String usuPerso, String passPerso) {
        this.idPerso = idPerso;
        this.nomPerso = nomPerso;
        this.apePerso = apePerso;
        this.dniPerso = dniPerso;
        this.direcPerso = direcPerso;
        this.emailPerso = emailPerso;
        this.fonoPerso = fonoPerso;
        this.usuPerso = usuPerso;
        this.passPerso = passPerso;
    }

    public Personal(String nomPerso, String apePerso, String dniPerso, String direcPerso, String emailPerso, String fonoPerso, String usuPerso, String passPerso, int idTipoPer) {
        this.nomPerso = nomPerso;
        this.apePerso = apePerso;
        this.dniPerso = dniPerso;
        this.direcPerso = direcPerso;
        this.emailPerso = emailPerso;
        this.fonoPerso = fonoPerso;
        this.usuPerso = usuPerso;
        this.passPerso = passPerso;
        this.idTipoPer = idTipoPer;
    }

    public Personal(int idPerso, String nomPerso, String apePerso, String dniPerso, String direcPerso, String emailPerso, String fonoPerso, String usuPerso, String passPerso, int idTipoPer) {
        this.idPerso = idPerso;
        this.nomPerso = nomPerso;
        this.apePerso = apePerso;
        this.dniPerso = dniPerso;
        this.direcPerso = direcPerso;
        this.emailPerso = emailPerso;
        this.fonoPerso = fonoPerso;
        this.usuPerso = usuPerso;
        this.passPerso = passPerso;
        this.idTipoPer = idTipoPer;
    }

    public int getIdPerso() {
        return idPerso;
    }

    public void setIdPerso(int idPerso) {
        this.idPerso = idPerso;
    }

    public String getNomPerso() {
        return nomPerso;
    }

    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }

    public String getApePerso() {
        return apePerso;
    }

    public void setApePerso(String apePerso) {
        this.apePerso = apePerso;
    }

    public String getDniPerso() {
        return dniPerso;
    }

    public void setDniPerso(String dniPerso) {
        this.dniPerso = dniPerso;
    }

    public String getDirecPerso() {
        return direcPerso;
    }

    public void setDirecPerso(String direcPerso) {
        this.direcPerso = direcPerso;
    }

    public String getEmailPerso() {
        return emailPerso;
    }

    public void setEmailPerso(String emailPerso) {
        this.emailPerso = emailPerso;
    }

    public String getFonoPerso() {
        return fonoPerso;
    }

    public void setFonoPerso(String fonoPerso) {
        this.fonoPerso = fonoPerso;
    }

    public String getUsuPerso() {
        return usuPerso;
    }

    public void setUsuPerso(String usuPerso) {
        this.usuPerso = usuPerso;
    }

    public String getPassPerso() {
        return passPerso;
    }

    public void setPassPerso(String passPerso) {
        this.passPerso = passPerso;
    }

    public int getIdTipoPer() {
        return idTipoPer;
    }

    public void setIdTipoPer(int idTipoPer) {
        this.idTipoPer = idTipoPer;
    }
    
    
    
    
    
}
