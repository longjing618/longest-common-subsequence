
public class LCS {
	static char[] Arr1 = {'0','A','B','C','B','D','A','B'};
	static char[] Arr2 = {'0','B','D','C','A','B','A'};
	static String[][] b = new String[10][9];
	static int[][] c = new int[10][9];
   static void LCS_LENGTH(char[] x,char[] y,String[][] b, int[][] c)
   {
	   for(int i=0;i<x.length;i++)
		   c[i][0]=0;
	   for(int j=0;j<y.length;j++)
		   c[0][j]=0;
	   for(int i=1;i<x.length;i++)
		   for(int j=1;j<y.length;j++)
			   if(x[i]==y[j])
			   {
				   c[i][j]=c[i-1][j-1]+1;
				   b[i][j]="lique";
			   }
			   else if(c[i-1][j]>=c[i][j-1])
			   {
				   c[i][j]=c[i-1][j];
				   b[i][j]="up";
			   }
			   else
			   {
				   c[i][j]=c[i][j-1];
				   b[i][j]="left";
			   }
   }
   
   static void PRINTLCS(String[][] b, char[] Arr,int la,int lb)
   {
	   if(la==0 || lb==0)
		   return;
	   if(b[la][lb]=="lique")
	   {
		   PRINTLCS(b,Arr,la-1,lb-1);
		   System.out.print(Arr[la]+" ");
	   }
	   else if(b[la][lb]=="up")
		   PRINTLCS(b,Arr,la-1,lb);
	   else
		   PRINTLCS(b,Arr,la,lb-1);
   }
   
   public static void main(String args[])
   {
	   LCS_LENGTH(Arr1,Arr2,b,c);

       PRINTLCS(b,Arr1,Arr1.length-1,Arr2.length-1);
   }
}
