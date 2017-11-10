<?php
// Скрипт example.php
$shortopts  = "";
$shortopts .= "f:";  // Обязательное значение
$shortopts .= "v::"; // Необязательное значение
$shortopts .= "abc"; // Эти параметры не принимают никаких значений

$longopts  = array(
    "required:",     // Обязательное значение
    "optional::",    // Необязательное значение
    "option",        // Нет значения
    "opt",           // Нет значения
);
$options = getopt($shortopts, $longopts);
var_dump($options);
?>
