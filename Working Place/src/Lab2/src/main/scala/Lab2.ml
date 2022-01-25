let rec find y x =
    match y with
    h::t when h=x -> true |
    h::t -> find(t)(x) |
    _ -> false;;

let find123 = find [1;2;3];;
find123 1 = true;;
find123 13 = false;;
find 5 = false;;

let findInChars = find ['a';'b';'c'];;
findInChars 'a' = true;;
findInChars 'x' = false;;
findInChars 'c' = true;;

let rec split2Tail list =
    let rec split2TailHelper(list, a,b) =
        match list with
            h::t -> split2TailHelper(t, h::b, a) |
            el -> (el@a, b)
    in split2TailHelper(list, [], []);;

split2Tail([1;2;3;4;5]) = ([5; 3; 1], [4; 2]);;
split2Tail([1;2;3;4;5;6;7;8;9;10]) = ([10; 8; 6; 4; 2], [9; 7; 5; 3; 1]);;