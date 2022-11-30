
package Model;
import Entity.PraktikanEntity07220;
import java.util.ArrayList;
public class PraktikanModel07220 implements ModelInterfaces07220 {
    private ArrayList<PraktikanEntity07220> praktikanEntityArrayList;
    
    public PraktikanModel07220(){
        praktikanEntityArrayList = new ArrayList<PraktikanEntity07220>();
    }
    public void insert(PraktikanEntity07220 praktikanEntity){
        praktikanEntityArrayList.add(praktikanEntity);
    }
    @Override
    public void view(){
        for(PraktikanEntity07220 praktikanEntity : praktikanEntityArrayList){
            System.out.println("===========================================");
            System.out.println(" NPM : "+praktikanEntity.getNpm()+"\n Nama : "+praktikanEntity.getNama()+"\n Password"+praktikanEntity.getPassword()+"\n no.telp"
            +praktikanEntity.getNo_telp()+"\n Tanggal Lahir"+praktikanEntity.getTglLahir());
            System.out.println("===========================================");
        }
    }
    @Override
    public int cekData(String npm, String password){
        int loop = 0;
        while(!praktikanEntityArrayList.get(loop).getNpm().equals(npm)&&!praktikanEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    public PraktikanEntity07220 getPraktikanEntityArrayList(int index){
        return praktikanEntityArrayList.get(index);
    }
}
