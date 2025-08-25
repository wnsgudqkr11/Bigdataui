package Ch01;

import java.util.Objects;

class C03Simple{
	int n;
	C03Simple(int n){
		this.n = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		//		
		if(obj instanceof C03Simple) {
			C03Simple down = (C03Simple)obj;
			return this.n==down.n;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return  Objects.hash(this.n);
	}
}
public class C03ObjectMain {
	
	public static void main(String[] args) {
		C03Simple ob1 = new C03Simple(1);
		System.out.println(ob1.toString());
		System.out.printf("%x\n",System.identityHashCode(ob1));
		
		C03Simple ob2 = new C03Simple(9);
		System.out.println(ob2.toString());
	}
}

