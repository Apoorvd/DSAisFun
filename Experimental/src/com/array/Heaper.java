package com.array;

public class Heaper {
    int data[];
    int lastPos;

    Heaper(int sizeOfHeap, int lp)
    {
        data= new int[sizeOfHeap];
        lastPos = lp;
    }

    public void insert(int n){
        int x= lastPos;
        int parent = x;

        if(lastPos == data.length)
        {
            System.out.println("Cannot be inserted");
            return ;
        }
        data[x] = n;
        while(parent != 0)
        {
            parent  = (x-1)/2;
            if( data[x] < data[parent])
            {
                int temp = data[x];
                data[x] = data[parent];
                data[parent] = temp;
                x=parent;
            }
            else
                break;
        }
        lastPos++;
    }

    public void display()
    {
        for(int i = 0 ; i<= this.lastPos ; i++)
        {
            System.out.println(this.data[i]);
        }
    }

    public int extract()// delete from top to find new min
    {

        int value = this.data[0];
        this.data[0] = this.data[lastPos-1];
        lastPos = lastPos-1;
        heapifyTop();
        return value;
    }

    public void heapifyTop()
    {
        int top = 0;
        while(top < lastPos)
        {
            int left = top*2 +1;
            int right = top*2 + 2;
            if( data[0] > data[left] && data[left] < data[right])
            {
                int temp = data[0];
                data[0] = data[left];
                data[left] = temp;
                top = left;
            }
            else if( data[0] > data[right] && data[right] < data[left])
            {
                int temp = data[0];
                data[0] = data[right];
                data[right] = temp;
                top = right;
            }
            else
                return;
        }
        return;
    }

    public static void main(String[] args) {
        Heaper obj = new Heaper(5,0);
        obj.insert(5);
        obj.insert(3);
        obj.insert(1);
        obj.insert(-1);
        System.out.println("Extracted value :"+obj.extract());
        System.out.println("Extracted value :"+obj.extract());
        System.out.println("LastPostion :"+obj.lastPos);
        obj.display();
    }
}
