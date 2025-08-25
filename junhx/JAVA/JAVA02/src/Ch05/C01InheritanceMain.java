//package Ch05;
//
//class Point2D{
//	int x;
//	int y;
//	
//	// 디폴트 생성자
//	Point2D(){
//		System.out.println("Point2D 디폴트 생성자 호출");
//	}
//}
//
//class Point3D extends Point2D{
//	int z;
//	
//	// 디폴트 생성자
//	Point3D(){
//		super();		// 상위클래스 Point2D() 생성자 호출 - 상위 클래스를 먼저 호출하겠다는 코드
//		System.out.println("Point3D 디폴트 생성자 호출");
//	}
//
//	@Override
//	public String toString() {
//		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
//	}
//		
//}
//

//public class C01InheritanceMain {
//
//	public static void main(String[] args) {
//		Point3D ob = new Point3D();
//		ob.x = 10;
//		ob.y = 20;
//		ob.z = 30;
//		System.out.println(ob);
//	}
//}
