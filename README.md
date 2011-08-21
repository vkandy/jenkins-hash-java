# Jenkins Hash

A Java implementation of Bob Jenkins' hash for non-cryptographic purposes. This implementaion can yield 32-bit and 64-bit hash values and can be used for hashtable lookups.

The algorithm implemented here is ideal for 32-bit architectures.

## What is Jenkins hash?
Jenkins hash is a general purpose hash algorithm created by Bob Jenkins. It takes an input of variable length and processes chunks of 12-bytes each and outputs a hash value as int (32 bits) or long (64 bits).

Advantages over other hash algorithms:
* Uniform distribution of hashes
* Very good <a href="http://en.wikipedia.org/wiki/Strict_Avalanche_Criterion">avalanche effect</a>
*  Faster than most hash algorithms in terms of number of instructions used in hash calculation. 

# Usage
    String message = "";
    JenkinsHash jh = new JenkinsHash();
    int pc = jh.hash32(message.getBytes());

    System.out.println(Integer.toHexString(pc));

# References

* Jenkins, Bob (May 2006). <a href="http://www.burtleburtle.net/bob/hash/doobs.html">The Hash</a>. Retrieved 2011-08-21.

