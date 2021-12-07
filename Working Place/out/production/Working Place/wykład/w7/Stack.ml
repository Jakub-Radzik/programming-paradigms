module type STACK_FUN =
    sig
        type 'a t
        exception Empty of string
        val create: unit -> 'a t
        val push: 'a * 'a t -> 'a t
        val top: 'a t -> 'a
        val pop: 'a t -> 'a t
        val isEmpty: 'a t -> bool
    end;;