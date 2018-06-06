import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PurchaseRanking{
	public static void main(String[] args) throws Exception {
		Map<String,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		try{
			int N = sc.nextInt();	//社員人数
			if (1<=N && N<=100){
				for(int i=0; i < N; i++){
					String name = sc.next();	//社員名
					if(1<= name.length() && name.length()<= 20){
						map.put(name, 0);
					}else{
						System.out.println("社員名は1文字以上20文字以下の必要があります");
						throw new Exception();
					}
				}
			}else{
				System.out.println("社員人数が多過ぎます");
				throw new Exception();
			}

    	int M = sc.nextInt();	//購入した本の数
			if (1<=M && M<=100){
      	for (int i = 0; i < M; i++) {
	    		String key = sc.next();
	      	int price = sc.nextInt();
					if(1<=price && price<=10_000){
						if(map.containsKey(key)){
							int total = map.get(key) + price;
							map.replace(key, total);
						}
					}else{
						System.out.println("金額が高過ぎます");
						throw new Exception();
					}
				}
			}else{
				System.out.println("冊数が多過ぎます");
				throw new Exception();
			}

			map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey()));
			System.out.println();

		}catch(Exception e){
			System.out.println("プロジェクトを終了します");
		}finally{
			sc.close();
		}
  }
}
