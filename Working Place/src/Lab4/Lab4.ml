(*  1   *)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt * 'a bt;;

let int_tree =Node(1,
            Node(2,Empty,Node(5,Empty,Empty,Empty),Empty),
            Node(3,Node(6,Empty,Empty,Empty),Empty,Empty),
            Node(4,Empty,Empty,Node(7,Empty,Empty,Empty))
            );;

let string_tree =Node("a",
    Node("b",Empty,Node("e",Empty,Empty,Empty),Empty),
    Node("c",Node("f",Empty,Empty,Empty),Empty,Empty),
    Node("d",Empty,Empty,Node("g",Empty,Empty,Empty))
    );;

let rec mapTree3 f = function
    | Empty -> Empty
    | Node(e,l,c,r) -> Node(f e,mapTree3 f l, mapTree3 f c, mapTree3 f r);;

mapTree3 (fun x -> 2*x) int_tree;;
mapTree3 (fun x -> 2*x) Empty;;
mapTree3 (fun x -> x^x) string_tree;;

(*  2   *)
(*a*)
(*słowo ma co najmniej jedną literę*)
type word = Word of char * string;;

(*sentencja to conajmniej jedno słowo*)
type sentence = Declarative of word * word list |
                Exclamatory of word * word list |
                Interrogative of word * word list;;

(*text to conajmniej jedna sentencja*)
type text = Text of sentence * sentence list;;

(*b*)

let char_to_string = String.make 1;;

let capital = function
    | Word(chr, str) -> (char_to_string (Char.uppercase chr)) ^ str;;

let capital (word: word) =
    match word with
    | Word(chr, str) -> (char_to_string (Char.uppercase chr)) ^ str;;

let word_to_string = function
    | Word(chr, str) -> " " ^ char_to_string (chr) ^ str ;;

let sentenceToString = function
    | Declarative(x, xs) -> capital (x) ^ (List.fold_left (fun acc -> fun x -> acc ^ word_to_string x) "" xs) ^ "."
    | Exclamatory(x, xs) -> capital (x) ^ (List.fold_left (fun acc -> fun x -> acc ^ word_to_string x) "" xs) ^ "!"
    | Interrogative(x, xs) -> capital (x) ^ (List.fold_left (fun acc -> fun x -> acc ^ word_to_string x) "" xs) ^ "?";;

let textToString = function
| Text(x, xs) -> (sentenceToString x) ^ (List.fold_left (fun acc -> fun x -> acc ^ " " ^ sentenceToString x) "" xs);;

let s1= Declarative(Word('a',"la"),[Word('m',"a");Word('k',"ota")]);;
let s2= Interrogative(Word('o',"la"),[Word('m',"a");Word('k',"ota")]);;
let s3= Exclamatory(Word('A',"la"),[Word('m',"a");Word('k',"ota")]);;
let t1= Text(s1,[s2;s3]);;

sentenceToString s1;;
textToString t1;;
