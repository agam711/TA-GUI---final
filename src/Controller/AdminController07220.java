
package Controller;
import Entity.AslabEntity07220;
import Entity.DaftarprakEntity07220;
import Entity.PraktikanEntity07220;
import java.util.Date;
import java.util.ArrayList;
public class AdminController07220 implements ControllerInterface07220{
    int indexLogin = 0;
    
    public AdminController07220(){
    
    }
    
    public void dataAslab(){
        String npmAslab [] = {"01","02","03","04","05","06","07"};
        String passwordAslab [] = {"01","02","03","04","05","06","07"};
        String namaAslab [] = {"Michael","Alan","Odil","Fitria","Sita","Eric","Fernanda"};
        String notelpAslab [] = {"01","02","03","04","05","06","07"};
        String tglLahirAslab [] = {"04/05/2000","01/12/2000","03/3/2000","23/06/2000","11/3/2000","13/9/2000","22/12/2000"};
        String laboratorium [] = {"RPL", "SO", "BASPROG", "BASPROG", "SO", "RPL", "RPL"};
        for (int i = 0; i<npmAslab.length; i++){
            AllObjectModel07220.aslabModel.insertAslab(new AslabEntity07220(npmAslab[i],passwordAslab[i],namaAslab[i],notelpAslab[i],
new Date(tglLahirAslab[i]), laboratorium[i]));
    }
}
    
    public void viewAslab(){
        AllObjectModel07220.aslabModel.view();
    }
    public void listPendaftarPraktikum(){
        AllObjectModel07220.daftarprakModel.view();
    }
    
    @Override
    public void login(String npm , String password){
        indexLogin = AllObjectModel07220.aslabModel.cekData(npm,password);
    }
    public AslabEntity07220 aslabEntity07220() {
        return AllObjectModel07220.aslabModel.showDataAslab(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexPrak, PraktikanEntity07220 praktikanEntity) {
        AllObjectModel07220.daftarprakModel.updateIsVerified(index, new DaftarprakEntity07220(praktikanEntity, true, indexPrak));
    }

    public ArrayList<DaftarprakEntity07220>cekDaftarprakModel(){
return AllObjectModel07220.daftarprakModel.getDaftarprakArrayList();
}
    
}


    