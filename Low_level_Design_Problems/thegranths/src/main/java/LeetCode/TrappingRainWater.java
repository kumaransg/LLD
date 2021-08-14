package LeetCode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right= new int[n];

        for(int i=0;i<n;i++){
            if(i==0) left[i]=height[i];
            else left[i]= left[i-1]>height[i-1]?left[i-1]:height[i-1];
        } //O(N)

        for(int i=n-1;i>=0;i--){
            if(i==n-1) right[i]=height[i];
            else right[i] = right[i+1]>height[i+1]?right[i+1]:height[i+1];
        }//O(N)

        int sum=0;

        for(int i=0;i<n;i++){
            int tmp = Math.min(left[i],right[i])-height[i];
            sum+= tmp>0?tmp:0;
        }//O(N)
        // 3*O(N) ~ O(N)

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
