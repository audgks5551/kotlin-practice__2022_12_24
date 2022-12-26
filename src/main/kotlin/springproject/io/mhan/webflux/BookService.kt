package springproject.io.mhan.webflux

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun getAll() : Flux<Book> {
        return bookRepository.findAll()
    }

    fun get(id: Long): Mono<Book> {
        return bookRepository.findById(id)
    }

    fun create(request: Map<String, Any>): Mono<Book> {
        val book = Book(
            name = request["name"].toString(),
            price = request["price"] as Int
        )

        return bookRepository.save(book)
    }

    fun delete(id: Long) : Mono<Void> {
        return bookRepository.deleteById(id)
    }

    fun getByName(name: String): Mono<Book> {
        return bookRepository.findByName(name)
    }
}