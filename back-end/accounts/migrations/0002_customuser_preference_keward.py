# Generated by Django 3.0.2 on 2020-09-03 17:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('accounts', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='customuser',
            name='preference_keward',
            field=models.CharField(default=1, max_length=255, verbose_name='선호 키워드'),
            preserve_default=False,
        ),
    ]