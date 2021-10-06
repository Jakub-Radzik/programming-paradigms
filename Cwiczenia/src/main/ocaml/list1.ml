(*1*)
let rec flatten xs =
if xs=[] then []
else List.hd xs @ flatten (List.tl xs);;
(*Tests 1*)
flatten([[1;2;3];[1;3];[5]]) = [1;2;3;1;3;5];;

(*2*)
let rec count (x, xs) =
if xs = [] then 0
else (if List.hd xs = x then 1 else 0) + count(x, List.tl xs);;

(*Tests 2*)
count('a', ['a';'l';'a']) = 2;;

(*3*)
let rec replicate(x, n) =
if n < 0 then failwith "Mnożnik mniejszy od 0"
else if n = 0 then []
else x :: replicate(x, n-1);;

(*Tests 3*)
replicate("s",3) = ["s";"s";"s"];;
replicate("s",0) = [];;

(*4*)
let rec sqrtList xs =
if xs = [] then []
else List.hd xs * List.hd xs :: sqrtList(List.tl xs);;

(*Tests 4*)
sqrtList([1;2;3;-4]) = [1;4;9;16];;
sqrtList([-1]) = [1];;
sqrtList([0]) = [0];;

(*5*)
let rec palindrome xs =
xs = List.rev xs;;

(*Tests 5*)
palindrome(['a';'l';'a']) = true;;
palindrome(['a';'l']) = false;;
palindrome([]) = true;;

(*6*)
let rec listLength xs =
if xs = [] then 0
else 1 + listLength(List.tl xs);;

(*Tests 6*)
listLength [1;1;1] = 3;;
listLength [1;2;1;2] = 4;;
listLength [] = 0;;
