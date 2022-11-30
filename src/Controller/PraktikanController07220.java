
package Controller;
import Entity.DaftarprakEntity07220;
import Entity.PraktikanEntity07220;
import Entity.PraktikumEntity07220;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class PraktikanController07220 implements ControllerInterface07220{
    int indexLogin = 0;
    public PraktikanController07220(){
        
    }
    public PraktikanEntity07220 getData(){
        return AllObjectModel07220.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    public void daftarPraktikum(int indexPraktikum , PraktikanEntity07220 praktikanEntity , boolean isVerified){
        AllObjectModel07220.daftarprakModel.insertDataDaftarprak(new DaftarprakEntity07220(praktikanEntity, isVerified,indexPraktikum));
    }
    
    @Override
    public void login(String npm , String password){
        indexLogin = AllObjectModel07220.praktikanModel.cekData(npm,password);
    }
    
    public void insert(String npm , String password , String nama , String no_telp , Date tglLahir , String kelas){
        AllObjectModel07220.praktikanModel.insert(new PraktikanEntity07220(npm,password,nama,no_telp,tglLahir,kelas));
    }
    public PraktikanEntity07220 PraktikanEntity(){
        return AllObjectModel07220.praktikanModel.getPraktikanEntityArrayList(indexLogin);
    }
    public int cekDaftarprak(String npm){
        int cek = AllObjectModel07220.daftarprakModel.cekData(npm, null);
        return cek;
    }
    public DaftarprakEntity07220 showDaftarprak(int index){
        return AllObjectModel07220.daftarprakModel.showDaftarprak(index);
    }
    public DefaultTableModel daftarprak(){
        DefaultTableModel dtmdaftarprak = new DefaultTableModel();
        Object[] kolom ={"NPM","Nama","Password","No Telp","Tgl Lahir","Praktikum","Verified","Kelas"};
        dtmdaftarprak.setColumnIdentifiers(kolom);
        int size = AllObjectModel07220.daftarprakModel.alldataprak().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(AllObjectModel07220.daftarprakModel.alldataprak().get(i).isVerified()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[8];
    data[0] = AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getNpm();
    data[1] = AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getNama();
    data[2] = AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getPassword();
    data[3] = AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getTglLahir();
    data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getTglLahir());
    data[5] = PraktikumEntity07220.nama[AllObjectModel07220.daftarprakModel.alldataprak().get(i).getIndexPraktikum()];
    data[6] = verif;
    data[7] = AllObjectModel07220.daftarprakModel.alldataprak().get(i).getPraktikan().getKelas();
    dtmdaftarprak.addRow(data);
        }
    return dtmdaftarprak;
    }
}

