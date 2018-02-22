
class testbubble{

static int ar[]=new int[10];

public void Swap(int first,int second)
{
int temp;
temp=ar[first];
ar[first]=ar[second];
ar[second]=temp;
}

public void Bubblesort(){
int outer,inner;
for (outer=ar.lenght-1;a>1;outer++){
for (inner=0;inner<outer;inner++){
if (ar[inner]<ar[inner+1])
{ Swap(inner,inner+1); }
                                  }
                                   }
                         }


public static void main(String arg[]){
for (int i=0; i<ar.length;i++){
ar[i]=(Math.random()*ar.lenght);
                              }
for(int i=0;i<ar.length;i++){
System.out.println("array in radom elements:"+ar[i]);
                            }
Bubblesort();
for(int i=0;i<ar.length;i++){
System.out.println("array in radom elements:"+ar[i]);
                            }
                                      }
}