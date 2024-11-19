import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution10 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> dt ;

        //ext 값이 val_ext 보다 작은 데이터 필터링
        if(ext.equals("code")){
            dt = func1(data,val_ext,0);
        }else if(ext.equals("date")){
            dt = func1(data,val_ext,1);
        }else if(ext.equals("maximum")){
            dt = func1(data,val_ext,2);
        }else{
            dt = func1(data,val_ext,3);
        }

        //sort_by로 정렬
        if(sort_by.equals("code")){
            dt= func2(dt,0);
        }else if(sort_by.equals("date")){
            dt= func2(dt,1);
        }else if(sort_by.equals("maximum")){
            dt= func2(dt,2);
        }else{
            dt= func2(dt,3);
        }
        for(int[] row : dt){
            System.out.println(Arrays.toString(row));
        }
        answer = new int[dt.size()][];
        for(int i = 0; i < dt.size(); i++){
            answer[i] = dt.get(i);
        }
        return answer;
    }

    public List<int[]> func1(int[][] data,int val_ext, int idx){
        List<int[]> dt = new ArrayList<>();

        for(int i=0;i<data.length;i++){
            if(data[i][idx]<val_ext){
                dt.add(data[i]);
            }
        }

        return dt;
    }

    public List<int[]> func2(List<int[]> data, int idx){
        for(int i=0;i<data.size();i++){
            for(int j=i+1;j<data.size();j++){
                if(data.get(i)[idx]> data.get(j)[idx]){
                    int [] temp = data.get(i);
                    data.set(i,data.get(j));
                    data.set(j,temp);
                }
            }
        }
        return data;
    }

}
