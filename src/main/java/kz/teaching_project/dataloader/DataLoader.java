package kz.teaching_project.dataloader;

import kz.teaching_project.entity.Category;
import kz.teaching_project.entity.Course;
import kz.teaching_project.entity.Lesson;
import kz.teaching_project.entity.Module;
import kz.teaching_project.entity.User;
import kz.teaching_project.entity.enums.LessonType;
import kz.teaching_project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public final class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    String initMode;

    private final CourseRepo courseRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;
    private final ModuleRepo moduleRepo;
    private final LessonRepo lessonRepo;


    @Override
    public void run(String... args) throws Exception {

        if (initMode.equals("always")) {


            User nuriddin = new User(
                    "Nuriddin Qurbonboyev",
                    "nuriddinqurbonboyev@mail.ru",
                    "nu2001",
                    "Java kz instructor",
                    "Java kz instructor",
                    "+1234567"
            );
            User rustam = new User(
                    "Maxmudov Rustam",
                    "MaxmudovRustam@mail.ru",
                    "ru2001",
                    "Java kz instructor",
                    "Java kz instructor",
                    "+1234567"
            );
            User asilbek = new User(
                    "Keldibayev Asilbek",
                    "KeldibayevAsilbek@mail.ru",
                    "as2002",
                    "Java kz instructor",
                    "Java kz instructor",
                    "+12345678"
            );
            userRepo.saveAll(
                    new ArrayList<>(
                            List.of(
                                    nuriddin, rustam,
                                    asilbek
                            )
                    )
            );


            Category web_development = new Category(
                    "Web Development", "web-development");
            Category game_development = new Category(
                    "Game Development", "game-development");
            Category web_design = new Category(
                    "Web Design", "web-design");
            Category game_design = new Category(
                    "Game Design", "game-design");
            categoryRepo.saveAll(
                    new ArrayList<>(
                            List.of(
                                    web_development,
                                    game_development,
                                    web_design,
                                    game_design
                            )
                    )
            );


            courseRepo.save(new Course(
                    "The Web Developer Bootcamp 2022", 13.99, List.of(nuriddin, rustam)
                    ,
                    "COMPLETELY REDONE - The only course you need to learn web development - HTML, CSS, JS, Node, and More!", "http://localhost:8080/files/TheWebDeveloper.jpgFb911f9cf-c77f-465e-ae8f-ad6f7f09c0d2",
                    """
                            Hi! Welcome to the brand new version of The Web Developer Bootcamp, Udemy's most popular web development course.  This course was just completely overhauled to prepare students for the 2022 job market, with over 60 hours of brand new content. This is the only course you need to learn web development. There are a lot of options for online developer training, but this course is without a doubt the most comprehensive and effective on the market.  Here's why:

                            This is the only Udemy course taught by a professional bootcamp instructor with a track record of success.

                            94% of my in-person bootcamp students go on to get full-time developer jobs. Most of them are complete beginners when I start working with them.

                            The previous 2 bootcamp programs that I taught cost $14,000 and $21,000.  This course is just as comprehensive but with brand new content for a fraction of the price.

                            Everything I cover is up-to-date and relevant to 2022's developer job market. This course does not cut any corners. I just spent 8 months redoing this behemoth of a course!

                            We build 13+ projects, including a gigantic production application called YelpCamp. No other course walks you through the creation of such a substantial application.

                            The course is constantly updated with new content, projects, and modules.  Think of it as a subscription to a never-ending supply of developer training.

                            You get to meet my cats and chickens!

                            When you're learning to program you often have to sacrifice learning the exciting and current technologies in favor of the "beginner friendly" classes.  With this course, you get the best of both worlds.  This is a course designed for the complete beginner, yet it covers some of the most exciting and relevant topics in the industry.""",
                    "The ins and outs of HTML5, CSS3, and Modern JavaScript for 2021\n" +
                            "Make REAL web applications using cutting-edge technologies\n" +
                            "Create responsive, accessible, and beautiful layouts\n" +
                            "Recognize and prevent common security exploits like SQL-Injection & XSS", "Computer with internet\n" +
                    "Free Time",
                    web_development
            ));
            courseRepo.save(new Course(
                    "Angular The Complete Guide 2022 Edition", 13.99, List.of(asilbek)
                    ,
                    "Master Angular 13 (formerly \"Angular 2\") and build awesome, reactive web apps with the successor of Angular.js", "http://localhost:8080/files/Angular.jpgFc017a8a3-f792-4c80-85c4-082ea89f11d4",
                    """
                            Join the most comprehensive and bestselling Angular course on Udemy and learn all about this amazing framework from the ground up, in great depth!
                            This course starts from scratch, you neither need to know Angular 1 nor Angular 2!""",
                    "Develop modern, complex, responsive and scalable web applications with Angular 13\n" +
                            "Fully understand the architecture behind an Angular application and how to use it\n" +
                            "Use the gained, deep understanding of the Angular fundamentals to quickly establish yourself as a frontend developer\n" +
                            "Create single-page applications with one of the most modern JavaScript frameworks out there", "Computer with internet\n" +
                    "Free Time",
                    web_development
            ));
            Course djangoCourse = new Course(
                    "The Ultimate Django Series: Part 1", 19.0, List.of(asilbek)
                    ,
                    "Master the Fundamentals of Web Development with Python and Django 3.2+", "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=width:705/https://www.filepicker.io/api/file/KHTdHnlEQsy8RfIAl4Mm", """
                    Have you always wanted to learn Web development with Python but didn't know where to start? Tired of lengthy, confusing, and outdated courses? Look no further.
                                        
                    A comprehensive, highly-practical, and step-by-step course that teaches you everything you need to know about Django from scratch. Learn the fundamentals in just five hours so you're ready for more advanced concepts covered in the second part of this course.
                    """,
                    """
                            Create Django projects with confidence
                            Understand the inner workings of Django
                            Troubleshoot issues like a pro
                            Get ready to learn advanced Django concepts""",
                    "To take this course, you need basic familiarity with Python and relational databases. No prior knowledge of Django is required. This course covers everything you need to know to go from zero to hero.",
                    web_development
            );
            courseRepo.save(djangoCourse);
            courseRepo.save(new Course(
                    "Complete C# Unity Game Developer 2D", 13.99, List.of(asilbek)
                    ,
                    "Learn Unity in C# & Code Your First Five 2D Video Games for Web, Mac & PC. The Tutorials Cover Tilemap",
                    """
                            Join the most comprehensive and bestselling Angular course on Udemy and learn all about this amazing framework from the ground up, in great depth!
                            This course starts from scratch, you neither need to know Angular 1 nor Angular 2!""",
                    "Learn C#, a powerful modern language, from scratch. No prior programming experience is necessary.\n" +
                            "Become excellent at using the Unity game engine.\n" +
                            "Build a solid foundation for game design and game development that will help you build your own games.\n" +
                            "Learn how object oriented programming works in practice.", "Mac or PC capable of running Unity 2019 or later.\n" +
                    "A passion and willingness to learn how to code.",
                    game_development
            ));

            courseRepo.save(new Course(
                    "Complete C# Unity Game Developer 3D", 13.99, List.of(asilbek)
                    ,
                    "Design & Develop Video Games. Learn C# in Unity Engine. Code Your first 3D Unity games for web, Mac & PC.",
                    """
                            This is the long-awaited sequel to the Complete Unity Developer - one of the most popular e-learning courses on the internet! Completely re-worked from scratch with brand-new projects and our latest teaching techniques. You will benefit from the fact we have already taught over a million students programming and game development, many shipping commercial games as a result.""",
                    "Develop a positive attitude to problem solving.\n" +
                            "Practical exercises EVERY VIDEO to build actual skills.\n" +
                            "Learn good coding and design patterns.\n" +
                            "Learn to use source control, a valuable tool for working in small teams.", "PC or Mac capable of running Unity 2017 or later.\n" +
                    "Regular internet access for Q&A and community.",
                    game_development
            ));

            courseRepo.save(new Course(
                    "Web Design for Beginners: Real World Coding in HTML & CSS", 13.99, List.of(asilbek)
                    ,
                    "Launch a career as a web designer by learning HTML5, CSS3, responsive design, Sass and more!", "http://localhost:8080/files/WebDesignBeginner.jpgFd3bc151f-5e11-4579-be7b-2a8fa2089640",
                    """
                            You can launch a new career in web development today by learning HTML & CSS. You don't need a computer science degree or expensive software. All you need is a computer, a bit of time, a lot of determination, and a teacher you trust. I've taught HTML and CSS to countless coworkers and held training sessions for fortune 100 companies. I am that teacher you can trust.""",
                    "Create any website layout you can imagine\n" +
                            "Support any device size with Responsive (mobile-friendly) Design\n" +
                            "Add tasteful animations and effects with CSS3\n" +
                            "Use common vocabulary from the design industry", "No prerequisite knowledge required\n" +
                    "No special ($$$) software required",
                    web_design
            ));

            courseRepo.save(new Course(
                    "Complete Web & Mobile Designer in 2022: UI/UX, Figma, +more", 13.99, List.of(asilbek, nuriddin, rustam)
                    ,
                    "Become a Designer in 2022! Master Mobile and Web Design, User Interface + User Experience (UI/UX Design), HTML, and CSS", "http://localhost:8080/files/ZtmWebDesign.jpgF99ed982f-1705-4282-9fed-7e018d7ad724",
                    """
                            You can launch a new career in web development today by learning HTML & CSS. You don't need a computer science degree or expensive software. All you need is a computer, a bit of time, a lot of determination, and a teacher you trust. I've taught HTML and CSS to countless coworkers and held training sessions for fortune 100 companies. I am that teacher you can trust.""",
                    "Build beautifully designed web and mobile projects for your customers using modern tools used by top companies in 2022\n" +
                            "Get hired as a Designer or become a freelancer that can work from anywhere and for anyone. Designers are in high demand!\n" +
                            "Includes 100+ assets and premium design templates that you can keep and use to customize for all your future projects\n" +
                            "Master Figma for your design needs then learn to convert your designs into a live HTML an CSS website", "No requirements. We teach you and show you everything from scratch! From Zero to Mastery\n" +
                    "Get ready to fall in love with Design and making everything you touch into beautiful projects for the rest of your life!",
                    web_design
            ));

            courseRepo.save(new Course(
                    "Pixel Art Master Course - Beginner to Professional/Freelance", 13.99, List.of(asilbek, nuriddin, rustam)
                    ,
                    "Learn ALL about pixel art in an always growing course! Get access to basic and pro techniques with daily feedbacks!",
                    """
                            This course teaches everything about pixel art for video games. From the very basics to the advanced techniques. Students will learn about lines, shapes, color theory and harmony, creating a color palette, designing characters, backgrounds, items, making animation and even how to start freelancing. You will also learn a lot about game design principles.""",
                    "Learn how to create both SIMPLE and COMPLEX pixel art! Objects, characters, environment, animations - ALL of it!\n" +
                            "Build your own game art with prototypes!\n" +
                            "Where to find clients, how to talk to them and how much to charge for your work!\n" +
                            "You will learn to design and animate pixel art for all game genres (e.g. RPG, Platformer, Top-down)\n" +
                            "Get access to Discord server where you can work on real projects with other people", "You need a working PC, preferably with a mouse and a keyboard.",
                    game_design
            ));


            Lesson introduction = new Lesson();




        }
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DataLoader) obj;
        return Objects.equals(this.courseRepo, that.courseRepo) &&
                Objects.equals(this.userRepo, that.userRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRepo, userRepo);
    }

    @Override
    public String toString() {
        return "DataLoader[" +
                "courseRepo=" + courseRepo + ", " +
                "userRepo=" + userRepo + ']';
    }

}
