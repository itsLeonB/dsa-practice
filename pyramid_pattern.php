<?php

$x = 5;

for ($i = 1; $i <= $x; $i++) {
    for ($j = 1; $j <= $x-$i; $j++) {
        echo " ";
    }

    for ($k = 1; $k <= 2*$i-1; $k++) {
        echo "*";
    }
    echo "\n";
}