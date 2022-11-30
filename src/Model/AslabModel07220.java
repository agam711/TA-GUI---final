
package Model;
import Entity.AslabEntity07220;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AslabModel07220 implements ModelInterfaces07220 {
    private ArrayList<AslabEntity07220> aslabEntityArrayList;
    
public AslabModel07220(){
    aslabEntityArrayList = new ArrayList<AslabEntity07220>();
}
    public void insertAslab(AslabEntity07220 aslab){
        aslabEntityArrayList.add(aslab);
    }
    @Override
public void view(){
    for(AslabEntity07220 aslabEntity : aslabEntityArrayList){
        System.out.println(aslabEntity.getNpm());
        System.out.println(aslabEntity.getNama());
        System.out.println(aslabEntity.getPassword());
        System.out.println(aslabEntity.getNo_telp());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(aslabEntity.getTglLahir()));
        System.out.println();
    }
}
@Override
public int cekData(String npm, String password){
    int loop = 0;
    for(AslabEntity07220 aslabEntity : aslabEntityArrayList){
        if(aslabEntity.getNpm().equals(npm) && aslabEntity.getPassword().equals(password)){
            break;
        }else{
            loop++;
        }
    }return loop;
}
public AslabEntity07220 showDataAslab(int index){
    return aslabEntityArrayList.get(index);
}
}
