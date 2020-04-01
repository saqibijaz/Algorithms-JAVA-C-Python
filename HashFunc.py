def rabin_karp(pattern,text, radix, modulus):
    #radix is the say with what will u multiply 
    #here in case of integers we will use 10
    #modulus is the factor with what the mod will be taken
    n = len(text)#checking lenth of text
    m = len(pattern)#checking lenth of pattern
    h = radix**(m-1) % modulus#hash function
    p = 0
    t = 0
    check=1
    for i in range(m):
        p = (radix*p+ int(pattern[i]))
        p=p% modulus
        
        t = (radix*t+ int(text[i])) 
        t=t% modulus
        
    for s in range(n - m):
        if p == t:
            for i in range(m):                 
                if pattern[i] != text[s+i]:
                    check=0    
                else:
                    check=1
            if check==1:
                print("Pattern occurs with shift {} ".format(s))
            if check==0:
                print("Spurious hit at{} ".format(s))
                        
        if s < n-m:
            t = (radix*(t - int(text[s])*h) +int(text[s+m]))
            t=t%modulus
            