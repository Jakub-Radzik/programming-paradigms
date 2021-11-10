(*2a*)
let rec fib x =
match x with
0 -> 0 |
1 -> 1 |
_ -> fib(x-1)+fib(x-2);;


(*2b*)
let rec fibTailExec(x, f1, f2) =
match x with
0 -> f1 |
1 -> f2 |
_ -> fibTailExec(x-1, f2, f1+f2);;

let rec fibTail x = fibTailExec(x, 0, 1);;

(*2 tests*)
fib 2 = 1;;
fib 10 = 55;;
fib 11 = 89;;

fibTail 2 = 1;;
fibTail 10 = 55;;
fibTail 11 = 89;;

(*3*)
let rec root3 a =
    let rec root3Rec x =
        if abs_float(x**3. -. a) <= (10.**(-15.)) *. abs_float(a) then x
        else root3Rec(x +. (a /. x**2. -. x) /. 3.)
    in root3Rec (if a <= 1. then a else a /. 3.);;

(*3 tests*)
root3 27. -. 3. <= (10.**(-15.));;
root3 216. -. 6. <= (10.**(-15.));;
root3 64. -. 4. <= (10.**(-15.));;
root3 1. -. 1.  <= (10.**(-15.));;

(*4*)
let patternA = (-2, -1, 0, 1, 2);;
let patternB = ((1,2),(0,1));;

(*4 tests*)
let (_,_,x,_,_) = patternA;;
let (_, (y,_)) = patternB;;

x = 0;;
y = 0;;

(*5*)
let rec initSegment(xs, ys) =
match (xs, ys) with
([], _) -> true |
(_, []) -> false |
_ -> if (List.hd xs = List.hd ys) then initSegment(List.tl xs, List.tl ys) else false;;

(*5 tests*)
initSegment([1; 2; 3],[1; 2; 3]) = true;;
initSegment([], []) = true;;
initSegment([], [1]) = true;;
initSegment([2], [1]) = false;;
initSegment(["a"; "b"], ["a"; "b"; "c"]) = true;;
initSegment(["a"; "b"; "c"], ["a"; "b"]) = false;;

(*6*)
let rec replaceNth(xs, n, x) =
match (xs, n) with
([], _) -> [] |
(_::tail, 0) -> x :: tail |
(head::tail, _) -> head :: replaceNth(tail, n-1, x);;

(*6m tests*)

let list1 = ['o'; 'l'; 'a'; 'm'; 'a'; 'k'; 'o'; 't'; 'a'];;
let list2 = ['o'; 's'; 'a'; 'm'; 'a'; 'k'; 'o'; 't'; 'a'];;

replaceNth(list1, 1, 's') = list2;;

replaceNth([1; 2; 3; 4; 5], 0, 10) = [10; 2; 3; 4; 5];;
replaceNth([1; 2; 3; 4; 5], 1, 10) = [1;10; 3; 4; 5];;
replaceNth([1; 2; 3; 4; 5], 3, 10) = [1; 2; 3; 10; 5];;
replaceNth([1; 2; 3; 4; 5], 11, 10) = [1; 2; 3; 4; 5];;
