(*1*)
let reverse4(a,b,c,d) = (d,c,b,a);;

reverse4(1,2,3,4) = (4,3,2,1);;
reverse4(1,2.5,'a',"aa") = ("aa",'a',2.5,1);;

(*2*)
let rec substitute (list, el1, el2) =
if list = [] then [] else
(if List.hd list = el1 then el2 else List.hd list) :: substitute(List.tl list, el1,el2);;

substitute([1;2;3;4;5], 3, 30) = [1;2;30;4;5];;
substitute([1;2;3;4;5], 10, 30) = [1;2;3;4;5];;
substitute([1;2;3;4;5], 1, 30) = [30;2;3;4;5];;
substitute([1;2;3;4;5], 5, 30) = [1;2;3;4;30];;

(*3*)
let rec insert (list, elem, idx) =
if idx < 0 then elem :: list else
if idx > 0 && list != [] then List.hd list :: insert(List.tl list, elem, idx-1) else
if list != [] then elem :: List.hd list :: List.tl list else elem :: [];;

insert([1;2;3;4], 0, 2) = [1; 2; 0; 3; 4];;
insert([1;2;3;4], 0, -2)=[0; 1; 2; 3; 4];;
insert([1;2;3;4], 0, 22)=[1; 2; 3; 4; 0];;
insert([1;2;3;4], 0, 3)=[1; 2; 3; 0; 4];;