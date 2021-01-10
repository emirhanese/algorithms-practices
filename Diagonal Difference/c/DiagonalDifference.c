#include<stdio.h>

int main() {

    int n, i, j, sum1 = 0, sum2= 0, result;
    
    scanf("%d",&n);
    
    int arr[n][n];
    
    for(i = 0; i < n; i++) {
        
        for(j = 0; j < n; j++) {
            
            scanf("%d",&arr[i][j]);
            
        }
    }
    
    for(i = 0; i < n; i++) {
        
        sum1 += arr[i][i];
        sum2 += arr[i][n - 1 - i];
        
    }
    
   if(sum1 > sum2) result = sum1 - sum2;
   
   else result = sum2 - sum1;
   
   printf("%d", result);
    
    return 0;
}
