# String Problems

Here the problems related to the string manipulation are presented.

## Longest Common Prefix

* Its too easy neglected
* check characters one by one from the start until they dont match.

```java

public static String lcp(String s, String t) {
    int n = Math.min(s.length(), t.length());

    for (int i = 0; i < n; i++) {
        if (s.charAt(i) != s.charAt(i)) 
            return s.substring(0, i);
    return s.substring(0, n);
    }
}
```

## Longest Repeated Substring Problem

- Given a string s.

- find the longest substring in s that appears at least twice.

### Brute Force 

The first method to solve this is via brute force. btw **Use Dynamic Programming**.

* we want to check the longest common prefixes of each substring with its subsequent substrings.

* a[bcdefg]
*   [cdefg]
*    [defg]
*     [efg] ...

```java

public static String lcp(String s, String t) {...}

public static String lrs(String s) {

    int n = s.length();
    String lrs = "";
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            String x = lcp(s.substring(i, n), s.substring(j, n));
            if (lrs.length() < x.length()) lrs = x;
        }
    }
    return lrs;
}


```

### suffix sorting

Notice that the checks in the brute force that do not start with the same characters return empty string. So lets not check them.

Also notice that the `substring(i, n)` will check only `substring(j, n)` where `j > i` so one may create a list of them which is called suffix strings.

Now the main idea is to check the suffixes that are closest to the current one. In other words sort the suffixes array then check the lcp for the adjacent ones only.

