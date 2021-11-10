(*1*)
let rec flatten1 xs =
if xs=[] then []
else List.hd xs @ flatten1 (List.tl xs);;
(*Tests 1*)
flatten([[1;2;3];[1;3];[5]]) = [1;2;3;1;3;5];;
flatten1([[1];[2]]) == [1;2];;
flatten1([[0]]) == [0];;
flatten1([]) == [];;
(*2*)
let rec count (x, xs) =
if xs = [] then 0
else (if List.hd xs = x then 1 else 0) + count(x, List.tl xs);;

(*Tests 2*)
count('a', ['a';'l';'a']) = 2;;
count('a', []) = 0;;
count('c', ['c';'c';'c']) = 3;;
count('c', ['a';'a';'a']) = 0;;

(*3*)
let rec replicate(x, n) =
if n < 0 then failwith "Mnożnik mniejszy od 0"
else if n = 0 then []
else x :: replicate(x, n-1);;

(*Tests 3*)
replicate("la", 3) = ["la";"la";"la"];;
replicate('a', 5) = ['a';'a';'a';'a';'a'];;
replicate('a', 1) = ['a'];;
replicate("abc", 2) = ["abc";"abc"];;
replicate(1, 2) = [1;1];;
replicate([1],3) = [[1];[1];[1]];;
replicate('s', 0) = [];;

(*4*)
let rec sqrList xs =
if xs = [] then []
else List.hd xs * List.hd xs :: sqrtList(List.tl xs);;

(*Tests 4*)
sqrtList([1;2;3;-4]) = [1;4;9;16];;
sqrList([20]) = [400];;
sqrList([-20]) = [400];;
sqrList([0;0;0]) = [0;0;0];;
sqrList([]) = [];;

(*5*)
let rec palindrome xs =
xs = List.rev xs;;

(*Tests 5*)
palindrome(['a';'l';'a']) = true;;
palindrome(['k';'a';'y';'a';'k']) = true;;
palindrome(['k';'a';'y';'a']) = false;;
palindrome([1;2;3]) = false;;
palindrome([3;2;3]) = true;;
palindrome([]) = true;;

(*6*)
let rec listLength xs =
if xs = [] then 0
else 1 + listLength(List.tl xs);;

(*Tests 6*)
listLength [1;1;1] = 3;;
listLength [1;2;1;2] = 4;;
listLength [] = 0;;
