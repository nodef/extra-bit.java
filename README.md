The [bit] is a basic unit of information in information theory, computing.<br>
:package: [Central](https://search.maven.org/artifact/io.github.javaf/extra-bit),
:scroll: [Releases](https://repo1.maven.org/maven2/io/github/javaf/extra-bit/),
:octocat: [GitHub](https://github.com/javaf/extra-bit/packages/??????????????),
:frog: [Bintray](https://bintray.com/beta/#/bintray/jcenter/io.github.javaf:extra-bit),
:peacock: [MvnRepository](https://mvnrepository.com/artifact/io.github.javaf/extra-bit),
:newspaper: [Javadoc](https://javaf.github.io/extra-bit/)
:blue_book: [Wiki](https://github.com/javaf/extra-bit/wiki).

<br>

This package includes [bit twiddling hacks] by Sean Eron Anderson and many others.

> Stability: Experimental.

[bit]: https://en.wikipedia.org/wiki/Bit
[bit twiddling hacks]: https://graphics.stanford.edu/~seander/bithacks.html

<br>

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

<br>
<br>


## Index

| Method       | Action                                   |
| ------------ | ---------------------------------------- |
| [get]        | Gets a bit.                              |
| [set]        | Sets a bit.                              |
| [toggle]     | Toggles a bit.                           |
| [swap]       | Swaps bit sequences.                     |
| [scan]       | Gets index of first set bit from LSB.    |
| [count]      | Counts bits set.                         |
| [parity]     | Gets n-bit parity.                       |
| [rotate]     | Rotates bits.                            |
| [reverse]    | Reverses all bits.                       |
| [merge]      | Merges bits as per mask.                 |
| [interleave] | Interleaves bits of two int16s.          |
| [signExtend] | Sign extends variable bit-width integer. |


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

<br>
<br>


## References

- [Publishing javadoc to github using maven](https://blog.progs.be/517/publishing-javadoc-to-github-using-maven)
- [Git error: “Host Key Verification Failed” when connecting to remote repository](https://stackoverflow.com/a/13364116/1413259)
- [Increment versions with the Maven Build Helper and the Versions Plugin](https://blog.codecentric.de/en/2015/04/increment-versions-maven-build-helper-versions-plugin/)

<br>
<br>

[![](https://img.youtube.com/vi/r3QQ6dm64xg/maxresdefault.jpg)](https://www.youtube.com/watch?v=r3QQ6dm64xg)
