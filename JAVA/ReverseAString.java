 String s = "abcd";
        int n = s.length();
        //System.out.println(n);
        char[] ch = s.toCharArray();
        for(int i = 0; i < n/2; i++)
        {
            char c = ch[i];
            ch[i] = ch[n-i-1];
            ch[n-i-1] = c;
        }
        System.out.println(String.valueOf(ch));
        