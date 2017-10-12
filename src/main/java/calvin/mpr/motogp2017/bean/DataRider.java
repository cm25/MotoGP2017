/*
 * [Copyrights by Calvin Mampioper - Tangerang Selatan, Ciputat 2017]
 * [Telp/HP : 081353000852, 081322631783]
 * [visit   : www.biriosisoftware.com]
 */
package calvin.mpr.motogp2017.bean;

/**
 *
 * @author Calvin Mampioper
 */
public class DataRider extends KategoriTeam {
    private String nama, negara;
    private Integer id, poin, nomor;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoin() {
        return poin;
    }

    public void setPoin(Integer poin) {
        this.poin = poin;
    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }
}
