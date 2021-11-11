let trzeci = (fun (x, y, z) -> z);;

(*Testy*)
trzeci(1, 2, 3);;
trzeci("a", "b", "c");;
trzeci(6, 4., "ala");;
trzeci([1;], [2;], []);;
