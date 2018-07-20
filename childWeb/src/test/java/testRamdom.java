import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 * 코드 생성기는 데이터 테이블 이름을 기반으로 해당 모델, 매퍼, 서비스, 컨트롤러 간소화 된 개발을 생성합니다.
 */
public class testRamdom {
		
	  	public static void randomExercise( int range, int set, String[] list, int ratio ){       
	  		
	  		int cardioSet = (set*ratio)/100;
	  		set -= cardioSet;

        	for(int i = 0 ; i<cardioSet ; i++) {
        		System.out.println("유산소 입니다." );
        	}
        	
	        Set<Integer> randomSet = new LinkedHashSet<Integer>(set);
	        for( Random ran = new Random() ; randomSet.size() < set && randomSet.size() < range ;  ) {
	        	randomSet.add(1 + ran.nextInt( range ));
	        }
	        
	        Iterator<Integer> itr = randomSet.iterator();
        	for(int i = 1 ; itr.hasNext() ; i++) {
        		System.out.println(list[itr.next()-1] + "입니다." );
        		
        		
        	}
	    }
	    
	    public static void main(String[] args) { 

//			String[] list = {"어깨","가슴","이두","삼두","팔"};
//	    	testRamdom.randomExercise(list.length, 5 , list , 0 );
	    	
	    	System.out.println("d" + 4%8);
	    	System.out.println("d" + 3%8);
	    	System.out.println("d" + 2%8);
	    	System.out.println("d" + 9%8);
	    }
    

}
