

public class Rectangle{
	
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Rectangle(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	
	}
	
	public static boolean intersact( Rectangle r1 , Rectangle r2 ){
		boolean x = false;
		boolean y = false;
		
		if( ((r1.x >= r2.x) && (r1.x <= r2.x+r2.width)) || (( (r1.x+r1.width) >= r2.x) && ( (r1.x+r1.width)<=(r2.x+r2.width))) ){
			x  = true;
		}
		
		if( (r1.y>=r2.y) && ( r1.y <= r2.y+r2.height) ){
			y = true;
		}
		if( (( (r1.y+r1.height) >= r2.y) && ( (r1.y+r1.height)<=(r2.y+r2.height))) ){
			y = true;
		}
		
		if( x && y){
			return true;
		}
		return false;
		
	}
	
	public boolean intersect(Rectangle r){
		int tw = this.width;
        int th = this.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
	}
	

}