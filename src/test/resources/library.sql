select count(id) from users;
-- 1855


select distinct count(id) from users;
-- 1855

-- result -> pass manually

select distinct name from books
where name = 'Marko Petrovic - SR';
