package com.array;

public class ae {
    public static void main(String[] args) {
        String r[]= new String[]{"....x..","x......",".....x.","......."};
        int n = r.length;
        int m = r[0].length();
        int x=0,y=0;
        int headx = 0, heady = 1;
        String s = "";
        while(x < n-1 && y < m-1)
        {
            if(r[x+headx].charAt(y+heady) == 'x') {
                s = s + "R";

                if( headx == 0 && heady == 1)
                {
                    headx = 1;
                    heady = 0;
                }
                else if( headx == 1 && heady == 0)
                {
                    headx = 0;
                    heady = -1;
                }
                else if( headx == 0 && heady == -1)
                {
                    headx = -1;
                    heady = 0;
                }
                else
                {
                    headx = 0;
                    heady =1;
                }

                x = x+headx;
                y= y+headx;

            }
            else{
                s = s + "G";
                x=x+headx;
                y=y+heady;
            }

            if( isRobotBounded(s)) {
                System.out.println(s.length()*2);
                System.exit(0);
            }


        }
    }

    public static boolean isRobotBounded(String instructions) {
        int dir = 1, x = 0, y = 0;

        for(int i = 0; i < instructions.length(); i++) {
            char temp = instructions.charAt(i);
            if(temp == 'L') {
                if(dir == 1) dir = 4;
                else dir--;
            }

            else if(temp == 'R') {
                if(dir == 4) dir = 1;
                else dir++;
            }
            else {
                if(dir == 1) y++;
                else if(dir == 2) x++;
                else if(dir == 4) x--;
                else if(dir == 3) y--;
            }
        }
        if(dir == 1) {
            if(y == 0 && x == 0) return true;
            return false;
        }
        if(dir == 2)
        {
            if( x>y)
                return true;
            return false;
        }
        return true;
    }
}
