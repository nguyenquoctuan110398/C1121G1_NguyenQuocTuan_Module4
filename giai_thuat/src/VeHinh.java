public class VeHinh {
    int h = ;
    for (let i = 0; i < h; i++) {
        for (let j = 0; j <= i; j++) {
            if ((j == 0) || (i == (h - 1)) || (i == j)) {
                document.write("*");
            } else {
                document.write("&nbsp&nbsp");
            }
        }
        document.write("<br>");
    }
}
