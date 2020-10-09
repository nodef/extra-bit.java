The [bit] is a basic unit of information in information theory, computing.
[:package:] [:ledger:]

This package includes [bit twiddling hacks] by Sean Eron Anderson and many others.

> Stability: Experimental.

```java
import io.github.javaf;

Bit.count(7);
// 3 (111 => 3)

Bit.parity(8, 2);
// 2 (10,00 => 10)

Bit.swap(6, 1, 0);
// 5 (110 => 101)

Bit.reverse(0xFFFF0000);
// 65535 (0x0000FFFF)

Bit.signExtend(15, 4);
// -1
```

### reference

| Method                | Action
|-----------------------|-------
| [get]                 | Gets a bit.
| [set]                 | Sets a bit.
| [toggle]              | Toggles a bit.
| [swap]                | Swaps bit sequences.
| [scan]                | Gets index of first set bit from LSB.
| [count]               | Counts bits set.
| [parity]              | Gets n-bit parity.
| [rotate]              | Rotates bits.
| [reverse]             | Reverses all bits.
| [merge]               | Merges bits as per mask.
| [interleave]          | Interleaves bits of two int16s.
| [signExtend]          | Sign extends variable bit-width integer.

<br>

### references

- [Publishing javadoc to github using maven :: justme](https://blog.progs.be/517/publishing-javadoc-to-github-using-maven)
- [Git error: “Host Key Verification Failed” when connecting to remote repository](https://stackoverflow.com/questions/13363553/git-error-host-key-verification-failed-when-connecting-to-remote-repository)
- [Increment versions with the Maven Build Helper and the Versions Plugin :: Dennis Schulte](https://blog.codecentric.de/en/2015/04/increment-versions-maven-build-helper-versions-plugin/)

[![javaf](https://merferry.glitch.me/card/extra-bit.svg)](https://javaf.github.io)

[bit]: https://en.wikipedia.org/wiki/Bit
[bit twiddling hacks]: https://graphics.stanford.edu/~seander/bithacks.html
[get]: https://github.com/javaf/extra-bit/wiki/get
[set]: https://github.com/javaf/extra-bit/wiki/set
[setAs]: https://github.com/javaf/extra-bit/wiki/setAs
[swap]: https://github.com/javaf/extra-bit/wiki/swap
[scan]: https://github.com/javaf/extra-bit/wiki/scan
[scanReverse]: https://github.com/javaf/extra-bit/wiki/scanReverse
[count]: https://github.com/javaf/extra-bit/wiki/count
[parity]: https://github.com/javaf/extra-bit/wiki/parity
[reverse]: https://github.com/javaf/extra-bit/wiki/reverse
[merge]: https://github.com/javaf/extra-bit/wiki/merge
[interleave]: https://github.com/javaf/extra-bit/wiki/interleave
[signExtend]: https://github.com/javaf/extra-bit/wiki/signExtend
[toggle]: https://github.com/javaf/extra-bit/wiki/toggle
[rotate]: https://github.com/javaf/extra-bit/wiki/rotate
[:package:]: https://search.maven.org/artifact/io.github.javaf/extra-bit
[:ledger:]: https://repo1.maven.org/maven2/io/github/javaf/extra-bit/
