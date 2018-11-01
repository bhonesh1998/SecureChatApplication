def compressString(string):
    prev = string[0]
    count = 1
    for i in range(1, len(string)):
        if prev != string[i]:
            print ('(%d, %s)' % (count, prev), end=" ")
            prev = string[i]
            count = 0
        count+=1
        
    print ('(%d, %s)' % (count, prev))

if __name__ == '__main__':
    string = input()
    
    compressString(string)