public class Main
{
    public static void main(String[] args)
    {
        short n=2;
        short m=2;
        short a=1;
        short b=2;
        short C=0;
        float r=0;
        for(short i=a; i<=n; i++)
        {
            for(short j=b; j<=m; j++)
            {
                if((i-C)==0) 
                {
                    System.out.println("Error");
                    System.exit(0);
                }
                r+=((float)i/(float)j)/(i-C);
            }
        }
        System.out.println("r= " + r);
    }
}
