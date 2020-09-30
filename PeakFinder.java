public class PeakFinder  
{ 
    // Sütunda max bulma
    static int gradientAscent(int[][] arr, int rows, int mid, int max) 
    { 
        int max_index = 0; 
        for (int i = 0; i < rows; i++) 
        { 
            if (max < arr[i][mid]) 
            { 
                max = arr[i][mid]; 
                max_index = i; 
            } 
        } 
        return max_index; 
    } 
  
    // [max] değeri değiştirme işlevi
    static int Max(int[][] arr, int rows, int mid, int max) 
    { 
        for (int i = 0; i < rows; i++) 
        { 
            if (max < arr[i][mid]) 
            { 
                max = arr[i][mid]; 
            } 
        } 
        return max; 
    } 
  
    // Peak bulma
    static int divideConquer(int[][] arr, int rows, int columns, int mid)  
    {
        int max = 0; 
        int max_index = gradientAscent(arr, rows, mid, max); 
        max = Max(arr, rows, mid, max); 
  
        // İlk veya son sütundaysak [max]=peak  
        // max is a peak 
        if (mid == 0 || mid == columns - 1) 
            return max; 
  
        // En fazla orta sütun aynı zamanda en yüksek ise [max]=peak 
        if (max >= arr[max_index][mid - 1] && max >= arr[max_index][mid + 1])
            return max; 
  
        // [max] soldaki değerden az ise 
        if (max < arr[max_index][mid - 1]) 
            return divideConquer(arr, rows, columns, (int)(mid - (double) mid / 2)); 
  
        else 
            return divideConquer(arr, rows, columns,(int)(mid + (double) mid / 2)); 
    } 
    
    
    static int findPeak(int[][] arr, int rows, int columns)  
    { 
        return divideConquer(arr, rows, columns, columns / 2); 
    } 
