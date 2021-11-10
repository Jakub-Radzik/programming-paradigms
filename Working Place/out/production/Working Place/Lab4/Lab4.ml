(*  1   *)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt * 'a bt;;

let n7 = Node(7, Empty, Empty, Empty);;
let n6 = Node(6, Empty, Empty, Empty);;
let n5 = Node(5, Empty, Empty, Empty);;
let n4 = Node(4, Empty, Empty, n7);;
let n3 = Node(3, n6, Empty, Empty);;
let n2 = Node(2, Empty, n5, Empty);;
let int_tree = Node(1, n2, n3, n4);;

let rec mapTree3 f = function
    | Empty -> Empty
    | Node(e,l,c,r) -> Node(f e,mapTree3 f l, mapTree3 f c, mapTree3 f r);;

mapTree3 (fun x -> 2*x) int_tree = Node (2, Node (4, Empty, Node (10, Empty, Empty, Empty), Empty),
                                    Node (6, Node (12, Empty, Empty, Empty), Empty, Empty),
                                    Node (8, Empty, Empty, Node (14, Empty, Empty, Empty)));;
mapTree3 (fun x -> 2*x) Empty = Empty;;

(*  2   *)
(*a*)
type word = Word of char * string;;

type sentence = Declarative of word * word list |
                Exclamatory of word * word list |
                Interrogative of word * word list;;

type text = Text of sentence * sentence list;;

(*test types*)
let ala = Word('a', "la");;
let ma = Word('m', "a");;
let kota = Word('k', "ota");;

let declarative= Declarative(ala,[ma;kota]);;
let interrogative= Interrogative(ala,[ma;kota]);;
let exclamatory= Exclamatory(ala,[ma;kota]);;
let text= Text(declarative,[interrogative;exclamatory]);;

(*b*)
(*helpers:*)
let char_to_string = String.make 1;;

let capital_letter (word: word) =
    match word with
    | Word(chr, str) -> (char_to_string (Char.uppercase chr)) ^ str;;

let word_to_string (word: word) =
    match word with
    | Word(chr, str) -> " " ^ char_to_string (chr) ^ str ;;


(*done:*)
let folder = fun acc -> fun word -> acc ^ word_to_string word;;
let sentence_to_string (sentence: sentence) =
    match sentence with
    | Declarative(x, xs) -> capital_letter(x) ^ (List.fold_left (folder) "" xs) ^ "."
    | Exclamatory(x, xs) -> capital_letter(x) ^ (List.fold_left (folder) "" xs) ^ "!"
    | Interrogative(x, xs) -> capital_letter(x) ^ (List.fold_left (folder) "" xs) ^ "?";;

let text_to_string (text: text) =
    match text with
    | Text(x, xs) -> (sentence_to_string x) ^ (List.fold_left (fun acc -> fun x -> acc ^ " " ^ sentence_to_string x) "" xs);;

sentence_to_string declarative = "Ala ma kota.";;
text_to_string text = "Ala ma kota. Ala ma kota? Ala ma kota!";;