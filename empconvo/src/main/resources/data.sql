DELETE
FROM category;

DELETE
FROM conversation;

DELETE
FROM  resource;

INSERT INTO category(categoryid, categoryname) VALUES (1, 'Harassment'), (2, 'Sexual Abuse');

INSERT INTO conversation(conversationid, survivorname, survivornumber, ffname, ffnumber, categoryid) VALUES (1, 'John', '318-112-3827', 'Jane', '318-321-4823', 1), (2, 'Meg', '318-421-5782', 'Johnny', '281-382-2818', 2);

INSERT INTO resource(resourceid, title, textbody, author, categoryid) VALUES
(1, 'How to Help if Someone Is Being Harassed','What would you do if you saw someone yelling at a woman on a bus, telling her to take off her hijab? If you saw someone attack an African-American man and tell him Donald Trump could deport him? If you saw a man throw a woman off the sidewalk as she walked her dogs?

As incidents of racist, sexist and Islamophobic harassment continue in the wake of Donald Trump’s election, many Americans will have to ask themselves these questions. And while every situation is different, the tips below — adapted from materials produced by the anti-street-harassment group Hollaback! and other organizations — may help people respond if they see someone being harassed.

Don’t assume you have to confront the harasser.

Directly confronting someone can be risky, because you can become a target, too. In many situations, another option is to talk to the person being harassed. You can ask if he or she needs help, or take a more indirect route by asking for the time or directions or starting a conversation about something other than the harassment. The artist Marie-Shirine Yener explains this tactic in a helpful comic.

Taking the focus off of the harasser can make him or her retreat. In addition, approaching the person being harassed gives that person control over the situation — he or she can choose to accept or decline your help or ask you to do something specific. If you don’t talk to the person experiencing harassment, you may not know what, if anything, he or she needs from you. Ask someone else for help.

If you don’t feel safe intervening yourself, you can ask someone else to step in. That could be a law enforcement officer. But it could also be a bus driver, train conductor, teacher or other authority figure, or simply another bystander.

If you can’t intervene during the incident, you can still help afterward.

Maybe you saw someone call a fellow subway passenger a derogatory name, then walk away. You can still approach the passenger and ask if she needs help. She might want someone to go with her to her destination or to help her report the incident to law enforcement or an anti-harassment group. Just hearing that someone else saw and recognized the harassment can be helpful for some people.', 'Anna North', 1),

(2, 'Tips for Talking with Survivors of Sexual Assault', 'It’s not always easy to know what to say when someone tells you they’ve been sexually assaulted, especially if they are a friend or family member. For a survivor, disclosing to someone they care about can be very difficult, so we encourage you to be as supportive and non-judgemental as possible.

Sometimes support means providing resources, such as how to reach the National Sexual Assault Hotline, seek medical attention, or report the crime to the police. But often listening is the best way to support a survivor.

Here are some specific phrases RAINN’s National Sexual Assault Hotline staff recommend to be supportive through a survivor’s healing process.

“I believe you. / It took a lot of courage to tell me about this.” It can be extremely difficult for survivors to come forward and share their story. They may feel ashamed, concerned that they won’t be believed, or worried they’ll be blamed. Leave any “why” questions or investigations to the experts—your job is to support this person. Be careful not to interpret calmness as a sign that the event did not occur—everyone responds to traumatic events differently. The best thing you can do is to believe them.

“It’s not your fault. / You didn’t do anything to deserve this.” Survivors may blame themselves, especially if they know the perpetrator personally. Remind the survivor, maybe even more than once, that they are not to blame.

“You are not alone. / I care about you and am here to listen or help in any way I can.” Let the survivor know that you are there for them and willing to listen to their story if they are comfortable sharing it. Assess if there are people in their life they feel comfortable going to, and remind them that there are service providers who will be able to support them as they heal from the experience.

“I’m sorry this happened. / This shouldn’t have happened to you.” Acknowledge that the experience has affected their life. Phrases like “This must be really tough for you,” and, “I’m so glad you are sharing this with me,” help to communicate empathy.

Continued Support
There’s no timetable when it comes to recovering from sexual violence. If someone trusted you enough to disclose the event to you, consider the following ways to show your continued support.

Avoid judgment. It can be difficult to watch a survivor struggle with the effects of sexual assault for an extended period of time. Avoid phrases that suggest they’re taking too long to recover such as, “You’ve been acting like this for a while now,” or “How much longer will you feel this way?”
Check in periodically. The event may have happened a long time ago, but that doesn’t mean the pain is gone. Check in with the survivor to remind them you still care about their well-being and believe their story.
Know your resources. You’re a strong supporter, but that doesn’t mean you’re equipped to manage someone else’s health. Become familiar with resources you can recommend to a survivor, such as the National Sexual Assault Hotline 800.656.HOPE (4673) and online.rainn.org, y en español a rainn.org/es.
It’s often helpful to contact your local sexual assault service provider for advice on medical care and laws surrounding sexual assault. If the survivor seeks medical attention or plans to report, offer to be there. Your presence can offer the support they need.
If someone you care about is considering suicide, learn the warning signs, and offer help and support. For more information about suicide prevention please visit the National Suicide Prevention Lifeline or call 800.273.TALK (8255) any time, day or night.
Encourage them to practice good self-care during this difficult time.', 'RAINN Foundation', 2);

alter sequence hibernate_sequence restart with 20;