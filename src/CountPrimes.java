public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                cnt++;
                for(int j = 2; j * i < n; j++){
                    notPrime[j * i] = true;
                }
            }
        }
        return cnt;
    }
}
