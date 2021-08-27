package com.onedev.dicoding.architecturecomponent.helper

import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.model.TvShows

object DataDummy {
    fun generateDataDummyMovies(): List<Movies> {
        val movies = ArrayList<Movies>()

        movies.add(
            Movies(
                "@drawable/poster_suicide_squad",
                "The Suicide Squad (2021)",
                "08/06/2021",
                "Action, Adventure, Fantasy, Comedy",
                "2h 12m",
                "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_paw_patrol",
                "PAW Patrol: The Movie (2021)",
                "08/20/2021",
                "Animation, Family, Adventure, Comedy",
                "1h 30m",
                "Ryder and the pups are called to Adventure City to stop Mayor Humdinger from turning the bustling metropolis into a state of chaos."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_narco_sub",
                "Narco Sub (2021)",
                "07/22/2021",
                "Action, Drama, Crime",
                "1h 33m",
                "A man will become a criminal to save his family. Director: Shawn Welling Writer: Derek H. Potts Stars: Tom Vera, Tom Sizemore, Lee Majors"
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_eggs_run",
                "Eggs Run (2021)",
                "08/12/2021",
                "Animation, Comedy",
                "1h 30m",
                "A rooster and his fowl partner embark on a dangerous trip to the Congo to recover their stolen eggs from a group of Russian goons."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_jungle_cruise",
                "Jungle Cruise (2021)",
                "07/30/2021",
                "Adventure, Fantasy, Comedy, Action",
                "2h 07m",
                "Dr. Lily Houghton enlists the aid of wisecracking skipper Frank Wolff to take her down the Amazon in his dilapidated boat. Together, they search for an ancient tree that holds the power to heal – a discovery that will change the future of medicine."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_black_widow",
                "Black Widow (2021)",
                "07/09/2021",
                "Action, Adventure, Thriller, Science Fiction",
                "2h 14m",
                "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_f_9",
                "F9 (2021)",
                "06/25/2021",
                "Action, Crime, Thriller",
                "2h 25m",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_space_jam",
                "Space Jam: A New Legacy (2021)",
                "07/16/2021",
                "Animation, Comedy, Family, Science Fiction",
                "1h 55m",
                "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_tomorrow_war",
                "The Tomorrow War (2021)",
                "07/01/2021",
                "Action, Science Fiction, Adventure",
                "2h 18m",
                "The world is stunned when a group of time travelers arrive from the year 2051 to deliver an urgent message: Thirty years in the future, mankind is losing a global war against a deadly alien species. The only hope for survival is for soldiers and civilians from the present to be transported to the future and join the fight. Among those recruited is high school teacher and family man Dan Forester. Determined to save the world for his young daughter, Dan teams up with a brilliant scientist and his estranged father in a desperate quest to rewrite the fate of the planet."
            )
        )

        movies.add(
            Movies(
                "@drawable/poster_infinite",
                "Infinite (2021)",
                "06/10/2021",
                "Science Fiction, Action, Thriller",
                "1h 46m",
                "Evan McCauley has skills he never learned and memories of places he has never visited. Self-medicated and on the brink of a mental breakdown, a secret group that call themselves “Infinites” come to his rescue, revealing that his memories are real."
            )
        )
        return movies
    }

    fun generateDataDummyTvShows(): List<TvShows> {
        val tvShows = ArrayList<TvShows>()

        tvShows.add(
            TvShows(
                "@drawable/poster_what_if",
                "What If...? (2021)",
                "One question changes everything.",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "32m",
                "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_loki",
                "Loki (2021)",
                "Loki's time has come.",
                "Drama, Sci-Fi & Fantasy",
                "52m",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant” or help fix the timeline and stop a greater threat."
            )
        )
        tvShows.add(
            TvShows(
                "@drawable/poster_falcon_winter_soldier",
                "The Falcon and the Winter Soldier (2021)",
                "Honor the shield.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "50m",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_wanda",
                "WandaVision (2021)",
                "Experience a new vision of reality.",
                "Sci-Fi & Fantasy, Mystery, Drama",
                "36m",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_titan",
                "Titans (2018)",
                "Heroes will rise ... or Gotham will fall.",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                "43m",
                "A team of young superheroes led by Nightwing (formerly Batman's first Robin) form to combat evil and other perils."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_flash",
                "The Flash (2014)",
                "The fastest man alive.",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_monster_at_wotk",
                "Monsters at Work (2021)",
                "It's laughter we're after.",
                "Family, Comedy, Animation",
                "27m",
                "Ever since he was a kid, Tylor Tuskmon has dreamed of becoming a Scarer just like his idol James P. Sullivan, and now that dream is about to come true... or not. The day he arrives at Monsters Incorporated to begin his dream job as a Scarer, he learns that scaring is out and laughter is in! After being reassigned to the Monsters, Inc. Facilities Team, Tylor sets his sights on a new goal: figuring out how to be funny and becoming a Jokester."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_arrow",
                "Arrow (2012)",
                "Heroes fall. Legends rise.",
                "Crime, Drama, Mystery, Action & Adventure",
                "42m",
                "Crime, Drama, Mystery, Action & Adventure."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_money_heist",
                "Money Heist (2017)",
                "The perfect robbery.",
                "Crime, Drama",
                "1h 10m",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing."
            )
        )

        tvShows.add(
            TvShows(
                "@drawable/poster_bad_batch",
                "The Bad Batch (2021)",
                "Experimental make their way through",
                "Animation, Sci-Fi & Fantasy, Action & Adventure",
                "1h 15m",
                "The 'Bad Batch' of elite and experimental clones make their way through an ever-changing galaxy in the immediate aftermath of the Clone Wars."
            )
        )

        return tvShows
    }
}